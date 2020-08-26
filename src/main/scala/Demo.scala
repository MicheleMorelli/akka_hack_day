import actors.{ActorTest, WordShorternerActor}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import messages.startMessage
object Demo extends App {

  val as:ActorSystem = ActorSystem("TestSystem")
  val actor:ActorRef = as.actorOf(Props[ActorTest], "TestActor")

  actor ! "aaaaaa"
  actor ! 9879
  actor ! 'a'
  actor ! "\\d".r
  actor ! 2.34

  val wordShortener1:ActorRef = as.actorOf(Props[WordShorternerActor], "WordShorthener1")
  val wordShortener2:ActorRef = as.actorOf(Props[WordShorternerActor], "WordShorthener2")

  wordShortener1 ! startMessage("This is a test!", wordShortener2)

}
