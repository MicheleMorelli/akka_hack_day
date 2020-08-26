import actors.ActorTest
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
object Demo extends App {

  val as:ActorSystem = ActorSystem("TestSystem")
  val actor:ActorRef = as.actorOf(Props[ActorTest], "TestActor")

  actor ! "aaaaaa"
  actor ! 9879
  actor ! 'a'
  actor ! "\\d".r
  actor ! 2.34

  as.terminate

}
