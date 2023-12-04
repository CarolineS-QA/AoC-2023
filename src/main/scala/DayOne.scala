import scala.io._

val input = Source.fromFile("src/main/resources/aoc-day1-input.txt").mkString

def splitByLine(block: String): Array[String] = {
  block.split("\n")
}

/** On each line, the calibration value is
 * combining the first digit and the last digit (in that order) to form a single two-digit number.
 **/
def extractCalibrationValues(string: String, part2: Boolean = false): Array[Int] = {
  val lines = splitByLine(string)
  val transform = lines.map(line =>
    if(part2) {
      whatDisValue(part2Update(line))
    } else
    whatDisValue(line)
  )
  return transform
}

def part2Update(line: String): String = {
  //watch out for where two numbers share a letter eg. twone, nineight, eightwo
  line
    .replace("one", "o1e")
    .replace("two", "t2o")
    .replace("three", "t3e")
    .replace("four", "4")
    .replace("five", "5e")
    .replace("six", "6")
    .replace("seven", "7n")
    .replace("eight", "e8t")
    .replace("nine", "n9e")
}

// get first and last digits (they can be the same) and create a two-digit number
def whatDisValue(line: String): Int = {
  val digits = line.filter(char => char.isDigit)
  val first = digits.head.asDigit
  val last = digits.last.asDigit

  first.toString.concat(last.toString).toIntOption.getOrElse(0)
}

@main def dayOne() = {
  println("First 'value' :P ")
  println(whatDisValue(splitByLine(input).head))
  // println(whatDisValue("bhfive4ths1811seven")) //41
  //  println("Total items to sum up:")
  //  println(extractCalibrationValues(input).length)
  println("Expected total:")
  println(extractCalibrationValues(input).sum)
  //  println(whatDisValue(part2Update("bhfive4ths1811seven"))) //57
  //  println(whatDisValue(part2Update("ssfzbthree8twoneqqn"))) //31
  println("Part 2 total:")
  println(extractCalibrationValues(input, true).sum)
  //53794 with direct replace one to 1
  //53884 is too low still accounting for language...
  //54424 too low (fixed eight problem)
  //54473 correct, forgot sevenine haha
}
