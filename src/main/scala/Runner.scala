
import scala.io.StdIn.readLine
import Answer._

@main def adventOfCode2023(): Unit = {
  println("Hello! Which day do you want the answer for?")
  val day = readLine()
  val answer = day match {
    case "1" => Answer.dayOne
    case "2" => Answer.dayTwo
    case "3" => Answer.dayThree
    case _ => "unknown day, try again :P"
  }

  println("Day " + day + " answer:")
  println(answer)
}
