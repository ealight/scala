package study.softserve.scala

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Series {

  def main(args: Array[String]): Unit = {
    println(seriesUnmut("49142", 3))
    println(seriesMut("49142", 4))
  }

  def seriesUnmut(source: String, n: Int): List[CharSequence] = {
    val steps: Int = source.length - n

    @tailrec
    def seriesInternal(resultList: List[String], step: Int): List[String] = {
      step match {
        case -1 => resultList
        case _ => seriesInternal(source.subSequence(step, step + n).toString :: resultList, step - 1)
      }
    }

    seriesInternal(Nil, steps)
  }


  def seriesMut(source: String, n: Int): List[String] = {
    val steps: Int = source.length - n
    val resultList = new ListBuffer[String]()

    for (step <- 0 to steps) {
      resultList += source.subSequence(step, step + n).toString
    }

    resultList.toList
  }
}
