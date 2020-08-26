package messages

import akka.actor.ActorRef

case class startMessage(str:String, other:ActorRef)
