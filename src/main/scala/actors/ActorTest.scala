package actors

import akka.actor.Actor

case class ActorTest() extends Actor {

  private def pr[A](obj:A, f: A=> A):Unit = {
    println(s"I received a ${obj.getClass.getSimpleName} instance: $obj.\nApplying function to it: ${f(obj)}")
  }

  override def receive: Receive = {
    case s:String => pr[String](s, _.toUpperCase)
    case n:Int => pr[Int](n, _ * 3)
    case n:Double => pr[Double](n, _ / 1.2)
    case other => pr[Any](other, x => s"GENERIC ACTION on $x")
  }
}
