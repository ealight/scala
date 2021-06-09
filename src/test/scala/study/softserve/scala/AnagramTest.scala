package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class AnagramTest extends AnyFunSuite with Matchers {
  test("Anagram") {
    val source: List[String] = List("enlists", "google", "inlets", "banana");
    val given: String = "listen"

    val expected: List[String] = List("inlets")
    val actual: List[String] = Anagram.find(source, given)

    actual shouldBe expected
  }
}