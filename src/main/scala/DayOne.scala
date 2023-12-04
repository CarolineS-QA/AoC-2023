import scala.io._

val input = Source.fromFile("src/main/resources/aoc-day1-input.txt").mkString

def splitByLine(block: String): Array[String] = {
  block.split("\n")
}

/** On each line, the calibration value is
 * combining the first digit and the last digit (in that order) to form a single two-digit number.
 **/
def extractCalibrationValues(string: String): Array[Int] = {
  val lines = splitByLine(string)
  val transform = lines.map(line => whatDisValue(line))
  return transform
}

// get first and last digits (they can be the same) and create a two-digit number
def whatDisValue(line: String): Int = {
  val digits = line.filter(char => char.isDigit)
  val first = digits.head.asDigit
  val last = digits.last.asDigit

  first.toString.concat(last.toString).toIntOption.getOrElse(0)
}

@main def dayOne() =
  println("First 'value' :P ")
  println(whatDisValue(splitByLine(input).head))
  println(whatDisValue("bhfive4ths1811seven"))
  println("Total items to sum up:")
  println(extractCalibrationValues(input).length)
  println("Expected total:")
  println(extractCalibrationValues(input).sum)