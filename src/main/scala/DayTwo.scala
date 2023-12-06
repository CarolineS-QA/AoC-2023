
import scala.io.Source
import InputUtils._

object DayTwo {
  val input: String = Source.fromFile("src/main/resources/aoc-day2-input.txt").mkString

  private def extractValidGameIndexes(string: String, part2: Boolean = false) = {
    val games = splitByLine(string)
    games.map(game =>
      if(part2) {
        cubePower(game)
      } else indexIfGameValid(game)
    )
  }

  //yes the parsing should be it's own func :P
  private def cubePower(game: String): Int = {
    //Game index: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    val indexedCubes = game.split(":")
    val index: Int = indexedCubes.head.split(" ").last.toInt
    val allCubes: Array[String] = indexedCubes.last.split("[,;]")

    //just want max cubes of all rounds, could of reused this
    val redMaxCount = cubeCounts(allCubes, "red").max
    val blueMaxCount = cubeCounts(allCubes, "blue").max
    val greenMaxCount = cubeCounts(allCubes, "green").max

    redMaxCount * blueMaxCount * greenMaxCount
  }

  // game is valid if less than or equal to 12 red cubes, 13 green cubes, and 14 blue cubes
  private def indexIfGameValid(game: String): Int = {
    //Game index: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    val indexedCubes = game.split(":")
    val index: Int = indexedCubes.head.split(" ").last.toInt
    val allCubes: Array[String] = indexedCubes.last.split("[,;]")

    //just want max cubes of all rounds
    val redCounts = cubeCounts(allCubes, "red").filter(count => count > 12)
    val blueCounts = cubeCounts(allCubes, "blue").filter(count => count > 14)
    val greenCounts = cubeCounts(allCubes, "green").filter(count => count > 13)

    // only return if game is below max
    if (redCounts.isEmpty && blueCounts.isEmpty && greenCounts.isEmpty) {
      index
    } else 0
  }

    // colour is "red" "blue" or "green"
    private def cubeCounts(cubes: Array[String], colour: String): Array[Int] = {
     cubes.filter(cube => cube.contains(colour)).map(cube => cube.replace(colour, "").trim.toInt)
    }

  def answer(): String = {
    s"Part 1: ${extractValidGameIndexes(input).sum} \nPart 2: ${extractValidGameIndexes(input, true).sum}"
  }

}
