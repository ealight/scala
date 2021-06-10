package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class KindergartenTest extends AnyFunSuite with Matchers {
  test("Kindergarten") {
    val kids: List[String] = List(
      "Alice", "Bob", "Charlie", "David",
      "Eve", "Fred", "Ginny", "Harriet",
      "Ileana", "Joseph", "Kincaid", "Larry"
    )

    val kindergarten = "[window][window][window]\n" +
      "RRCVVRCVGCCVRRCCCCCGRVCG\n" +
      "VRVGRCVRVVVVVRGGRVRVVVCG"

    val expected = List("Radishes", "Radishes", "Violets", "Radishes")
    val actual = Kindergarten.getPlantsByChildren("Alice", kids, kindergarten)

    actual shouldBe expected

    //подивись ще функцію createGarden я не знаю як її затестувати :)

    println(Kindergarten.createGarden(5))
  }
}
