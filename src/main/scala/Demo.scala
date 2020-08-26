import actors.{ActorAsking, ActorTest, WordShorternerActor}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import messages.questions.Question
import messages.{AskMessage, startMessage}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration._

object Demo extends App {

  val as: ActorSystem = ActorSystem("TestSystem")
  val actor: ActorRef = as.actorOf(Props[ActorTest], "TestActor")
  //
  //  actor ! "aaaaaa"
  //  actor ! 9879
  //  actor ! 'a'
  //  actor ! "\\d".r
  //  actor ! 2.34
  //
  //  val wordShortener1:ActorRef = as.actorOf(Props[WordShorternerActor], "WordShorthener1")
  //  val wordShortener2:ActorRef = as.actorOf(Props[WordShorternerActor], "WordShorthener2")
  //
  //  wordShortener1 ! startMessage("This is a test!", wordShortener2)


  val asker: ActorRef = as.actorOf(Props(ActorAsking("Tom", "Smith", 45)), "asker")
  val responder: ActorRef = as.actorOf(Props(ActorAsking("Julie", "London", 39)), "responder")

  // Timeout is needed for the Ask pattern (using ?)
  implicit val timeout: Timeout = Timeout(2.seconds)
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  asker ! startMessage("name", responder)
  val ans1: Future[Any] = asker ? AskMessage(Question("age"))
  val ans2: Future[Any] = responder ? AskMessage(Question("surname"))

  for {
    a1 <- ans1
    a2 <- ans2
  } yield println(s"I received the following answers: \n$a1\n$a2")


}
