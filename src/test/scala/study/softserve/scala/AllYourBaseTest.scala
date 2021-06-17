package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class AllYourBaseTest extends AnyFunSuite with Matchers{

  test("From base 2 to base 101") {
    val value = 1010101
    val base = 10

    val expected = Some("85")
    val actual = AllYourBase.convertFromBaseToBase(value, base)

    actual shouldBe expected
  }

  test("From base 10 to base 2") {
    val value = 566
    val base = 2

    val expected = Some("1000110110")
    val actual = AllYourBase.convertFromBaseToBase(value, base)

    actual shouldBe expected
  }

}
