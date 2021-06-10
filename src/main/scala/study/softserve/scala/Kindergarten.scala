package study.softserve.scala

import scala.util.Random

/**
 * Link: https://exercism.io/my/solutions/7b1e3fc5e13c4f2e8ab194a8c7c434ce
 *
 * Given a diagram, determine which plants each child in the kindergarten class is responsible for.
 *
 * The kindergarten class is learning about growing plants. The teacher thought it would be a good idea to give them actual seeds, plant them in actual dirt, and grow actual plants.
 *
 * They've chosen to grow grass, clover, radishes, and violets.
 *
 * To this end, the children have put little cups along the window sills, and planted one type of plant in each cup, choosing randomly from the available types of seeds.
 *
 * [window][window][window]
 * ........................ # each dot represents a cup
 * ........................
 * There are 12 children in the class:
 *
 * Alice, Bob, Charlie, David,
 * Eve, Fred, Ginny, Harriet,
 * Ileana, Joseph, Kincaid, and Larry.
 * Each child gets 4 cups, two on each row. Their teacher assigns cups to the children alphabetically by their names.
 *
 * The following diagram represents Alice's plants:
 *
 * [window][window][window]
 * VR......................
 * RG......................
 * In the first row, nearest the windows, she has a violet and a radish. In the second row she has a radish and some grass.
 *
 * Your program will be given the plants from left-to-right starting with the row nearest the windows. From this, it should be able to determine which plants belong to each student.
 *
 * For example, if it's told that the garden looks like so:
 *
 * [window][window][window]
 * VRCGVVRVCGGCCGVRGCVCGCGV
 * VRCCCGCRRGVCGCRVVCVGCGCV
 * Then if asked for Alice's plants, it should provide:
 *
 * Violets, radishes, violets, radishes
 * While asking for Bob's plants would yield:
 *
 * Clover, grass, clover, clover
 */
object Kindergarten {
  val plants: Map[String, Char] = Map("Grass" -> 'G', "Clover" -> 'C', "Radishes" -> 'R', "Violets" -> 'V')

  def createGarden(windowsCount: Int): String = {
    val windows: String = (0 until windowsCount).map(_ => "[window]").mkString
    val maxCupPerLine = windows.length

    val lines = (0 until maxCupPerLine * 2).map(_ => Random.shuffle(plants).head._2).splitAt(maxCupPerLine)
    List(windows, lines._1.mkString, lines._2.mkString).mkString("\n")
  }

  def getPlantsByChildren(children: String, kids: List[String], kindergarten: String): List[String] = {
    kindergarten
      .split("\n")
      .toList
      .flatMap(
        _.zipWithIndex
          .filter(x => (x._2 >= kids.indexOf(children) * 2) && (x._2 < (kids.indexOf(children) + 1) * 2))
          .map(_._1))
      .flatMap(x => plants.filter(_._2 == x).keys)
  }
}
