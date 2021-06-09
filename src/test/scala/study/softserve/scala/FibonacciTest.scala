package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class FibonacciTest extends AnyFunSuite with Matchers {
  test("Fibonacci") {
    val steps = 10;
    val expected: List[Int] = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    val actual: List[Int] = Fibonacci.fibonacci(steps);

    actual shouldBe expected
  }
}
