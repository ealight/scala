package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class NPrimeTest extends AnyFunSuite with Matchers{

  test("NPrime") {
    val number = 6;
    val expected: Int = 13
    val actual: Int = NPrime.getPrimeByNumber(number);

    actual shouldBe expected
  }

}
