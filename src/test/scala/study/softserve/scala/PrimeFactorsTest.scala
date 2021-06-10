package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PrimeFactorsTest extends AnyFunSuite with Matchers {

  test("PrimeFactors") {
    val number = 60;
    val expected = List(2, 2, 3, 5)
    val actual = PrimeFactors.getPrimeFactors(number);

    actual shouldBe expected
  }

}
