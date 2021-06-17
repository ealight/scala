package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class WordyTest extends AnyFunSuite with Matchers {

  test("Wordy some result") {
    val source: String = "What is 1 plus 3 minus 1 multiplied by 5 divided by 3"

    val expected: Option[Int] = Some(5)
    val actual = Wordy.parseString(source)

    actual shouldBe expected
  }

  test("Wordy bad request") {
    val source: String = "What is 1 plus 3 minus 1 multiplied by 5 divided by 3 minus"

    val expected = None
    val actual = Wordy.parseString(source)

    actual shouldBe expected
  }

  test("Wordy none result") {
    val source: String = "Who is the best rock-singer?"

    val expected = None
    val actual = Wordy.parseString(source)

    actual shouldBe expected
  }
}
