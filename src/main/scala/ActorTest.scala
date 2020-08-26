import akka.actor.Actor

case class ActorTest() extends Actor {

  private def pr[A](obj:A, f: A=> A):Unit = {
    println(s"I received a ${obj.getClass.getName} instance: $obj.\nApplying ${f.toString}: ${f(obj)}")
  }

  override def receive: Receive = {
    case s:String => pr[String](s, _.toUpperCase)
    case n:Int => pr[Int](n, _ * 3)
    case other => pr[Any](other, x => println(s"GENERIC ACTION on $other"))
  }
}
