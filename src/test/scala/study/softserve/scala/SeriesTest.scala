package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SeriesTest extends AnyFunSuite with Matchers{
  test("Series recursion") {
    val length = 3
    val source = "49142"
    val expected: List[String] = List("491", "914", "142")
    val actual: List[String] = Series.seriesRecursion(source, length)

    actual shouldBe expected
  }

  test("Series functional") {
    val length = 4
    val source = "49142"
    val expected: List[String] = List("4914", "9142")
    val actual: List[String] = Series.seriesImmutable(source, length)

    actual shouldBe expected
  }
}
