package study.softserve.scala

object NPrime {
  def getPrimeByNumber(number: Int): Int = Stream.from(2).filter(isPrime)(number - 1)
  private def isPrime(number: Int): Boolean = (2 to Math.sqrt(number).toInt).forall(number % _ != 0)
}
