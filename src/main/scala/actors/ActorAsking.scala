package actors

import akka.actor.Actor
import messages.{AskMessage, startMessage}
import messages.questions.{AgeQuestion, Answer, Question, IntAnswer, NameQuestion, StringAnswer, SurnameQuestion}

case class ActorAsking(name: String, surname: String, age: Int) extends Actor {

  override def receive: Receive = {
    case startMessage(str,other) => other ! AskMessage(Question(str))

    case AskMessage(question) =>
      println(self)
      println(s"ASKING $question")
      sender ! answer(question)
    case a:Answer =>
      println(self)
      println(s"RECEIVED $a")
  }

  def answer(question: Question): Answer = {
      question match {
        case _: NameQuestion => StringAnswer(name)
        case _: SurnameQuestion => StringAnswer(surname)
        case _: AgeQuestion => IntAnswer(age)
        case _ => StringAnswer("This was a pointless question!")
      }

  }
}
