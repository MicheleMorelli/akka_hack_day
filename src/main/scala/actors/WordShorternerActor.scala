package actors

import akka.actor.{Actor, ActorRef}
import messages.{shortenWordMessage, startMessage}

case class WordShorternerActor() extends Actor {

  override def receive: Receive = {
    case startMessage(str, actorRef) => startProcessing(str, actorRef)
    case shortenWordMessage(str) => shortenWord(str)
  }

  def startProcessing(str:String, other:ActorRef): Unit = {
    println(self)
    println(s"STARTING SHORTENING $str")
    other ! shortenWordMessage(str.tail)
  }

  def shortenWord(str:String):Unit = {
    str match {
      case "" =>
        println("ALL DONE!")
        context.system.terminate
      case s =>
        println(self)
        println(s)
        sender ! shortenWordMessage(s.tail)
    }

  }
}
