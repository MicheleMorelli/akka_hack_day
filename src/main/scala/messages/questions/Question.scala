package messages.questions

sealed trait Question

final case class NameQuestion() extends Question

final case class SurnameQuestion() extends Question

final case class AgeQuestion() extends Question

final case class PointlessQuestion() extends Question

object Question {
  def apply(str: String): Question = {
    str match {
      case "name" => NameQuestion()
      case "surname" => SurnameQuestion()
      case "age" => AgeQuestion()
      case _ => PointlessQuestion()
    }
  }
}
