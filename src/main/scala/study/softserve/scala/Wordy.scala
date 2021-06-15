package study.softserve.scala


object Wordy {
  def parseString(source: String): Option[Int] = {
    val operations = Map(
      "plus" -> ((i: Int, j: Int) => i + j),
      "minus" -> ((i: Int, j: Int) => i - j),
      "multiplied by" -> ((i: Int, j: Int) => i * j),
      "divided by" -> ((i: Int, j: Int) => i / j)
    )

    val indexes = source
      .split("\\D")
      .filter(_.nonEmpty)
      .map(_.toInt)
      .toList

    val ops = source
      .split("[^(divided by|minus|multiplied by|plus|)]")
      .flatMap(x => operations.filter(op => op._1 == x.trim).values)
      .toList

    val res: Option[Int] = {
      if (indexes.isEmpty || indexes.size == ops.size) None
      else Some(
        ops
          .zipWithIndex
          .foldLeft(indexes.head) { (x, y) =>
            y._1(x, indexes(y._2 + 1))
          }
      )
    }

    res
  }

}
