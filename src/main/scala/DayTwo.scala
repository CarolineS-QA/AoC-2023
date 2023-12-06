
import scala.io.Source
import InputUtils._

object DayTwo {
  val input: String = Source.fromFile("src/main/resources/aoc-day2-input.txt").mkString

  // game is valid if less than or equal to 12 red cubes, 13 green cubes, and 14 blue cubes
  private def extractValidGameIndexes(string: String) = {
    val games = splitByLine(string)
    games.map(game =>
      isGameValid(game)
    )
  }
  
  // game is valid if less than or equal to 12 red cubes, 13 green cubes, and 14 blue cubes
  private def isGameValid(game: String): Int = {
    //Game index: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    val indexedCubes = game.split(":")
    val index = indexedCubes.head.split(" ").last
    val allCubes = indexedCubes.last.split("[,;]")

    //just want max cubes of all rounds
    val redCounts = cubeCounts(allCubes, "red").filter(count => count > 12)
    val blueCounts = cubeCounts(allCubes, "blue").filter(count => count > 14)
    val greenCounts = cubeCounts(allCubes, "green").filter(count => count > 13)

    // only return if game is below max
    if (redCounts.isEmpty && blueCounts.isEmpty && greenCounts.isEmpty) {
      index.toInt
    } else 0
  }

    // colour is "red" "blue" or "green"
    private def cubeCounts(cubes: Array[String], colour: String): Array[Int] = {
     cubes.filter(cube => cube.contains(colour)).map(cube => cube.replace(colour, "").trim.toInt)
    }
  
  def answer(): String = {
    s"Part 1: ${extractValidGameIndexes(input).sum} \nPart 2: ${}"
  }

}
