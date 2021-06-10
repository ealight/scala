package study.softserve.scala

import scala.annotation.tailrec

/**
 * Convert a number, represented as a sequence of digits in one base, to any other base.
 *
 * Implement general base conversion. Given a number in base a, represented as a sequence of digits, convert it to base b.
 *
 * Note
 * Try to implement the conversion yourself. Do not use something else to perform the conversion for you.
 * About Positional Notation
 * In positional notation, a number in base b can be understood as a linear combination of powers of b.
 *
 * The number 42, in base 10, means:
 *
 * (4 * 10^1) + (2 * 10^0)
 *
 * The number 101010, in base 2, means:
 *
 * (1 * 2^5) + (0 * 2^4) + (1 * 2^3) + (0 * 2^2) + (1 * 2^1) + (0 * 2^0)
 *
 * The number 1120, in base 3, means:
 *
 * (1 * 3^3) + (1 * 3^2) + (2 * 3^1) + (0 * 3^0)
 */
object AllYourBase {
  def convertFromBaseToBase(number: Long, toBase: Long): Option[String] = {
    toBase match {
      case 2 => Some(toBase2(number))
      case 10 => Some(toBase10(number))
      case _ => None
    }
  }

  def toBase10(number: Long): String =
    number.toString.reverse.zipWithIndex.map(zipped => zipped._1.asDigit * Math.pow(2, zipped._2))
      .sum.toInt.toString

  def toBase2(number: Long): String = {
    @tailrec
    def toBase2Internal(number: Long, resultList: List[String] = Nil): List[String] = {
      number match {
        case 0 => resultList
        case _ => toBase2Internal(number / 2, (number % 2).toString :: resultList)
      }
    }

    toBase2Internal(number).mkString
  }
}
