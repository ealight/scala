package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class WordCountTest extends AnyFunSuite with Matchers {
  test("WordCount") {
    val source: String = "That's the password: 'PASSWORD 123'!, cried the Special Agent. So I fled"
    val expected: Map[String, Int] = Map(
      "that's" -> 1,
      "fled" -> 1,
      "so" -> 1,
      "123" -> 1,
      "agent" -> 1,
      "i" -> 1,
      "cried" -> 1,
      "special" -> 1,
      "the" -> 2,
      "password" -> 2
    )
    val actual = WordCount.findDuplicates(source)

    actual shouldBe expected
  }
}
