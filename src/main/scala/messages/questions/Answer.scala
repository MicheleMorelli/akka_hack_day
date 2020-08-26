package messages.questions

trait Answer
case class StringAnswer(v: String) extends Answer
case class IntAnswer(v: Int) extends Answer
case class AnyAnswer(v: Any) extends Answer

