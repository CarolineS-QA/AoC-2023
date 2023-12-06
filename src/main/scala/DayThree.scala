
import InputUtils.*

import scala.io.Source

object DayThree {
  val input: String = Source.fromFile("src/main/resources/aoc-day3-input.txt").mkString

  private def parseInput(string: String, part2: Boolean = false) = {
    val lines = splitByLine(string)
    lines.map(line => parseLine(line))
  }
  
  private def parseLine(line: String) = {
    ""
  }
    
  def answer(): String = {
    s"Part 1: ${ } \nPart 2: ${ }"
  }

}
