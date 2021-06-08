package study.softserve.scala

import scala.annotation.tailrec

/**
 * Fibonacci numbers
 */
object Fibonacci {

  def main(args: Array[String]): Unit = {
   println(fibonacci(10).reverse)
  }

  def fibonacci(maxSteps: Int): List[Int] = {
    @tailrec
    def fibonacciInternal(step: Int, resultList: List[Int]): List[Int] = {
      step match {
          case 0 => resultList
          case _ => resultList match {
            case head :: tail => fibonacciInternal(step - 1, (head + tail.head) :: resultList)
          }
        }
    }

    fibonacciInternal(maxSteps, List(1, 0))
  }

}
