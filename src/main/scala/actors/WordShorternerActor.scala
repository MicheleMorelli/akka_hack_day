package actors

import akka.actor.Actor

case class WordShorternerActor() extends Actor {

  override def receive: Receive = {
    case s:String => pr[String](s, _.toUpperCase)
  }
}
