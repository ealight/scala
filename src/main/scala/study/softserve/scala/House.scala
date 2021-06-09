package study.softserve.scala

/**
 * Recite the nursery rhyme 'This is the House that Jack Built'.
 *
 * [The] process of placing a phrase of clause within another phrase of clause is called embedding.
 * It is through the processes of recursion and embedding that we are able to take
 * a finite number of forms (words and phrases) and construct an infinite number of expressions.
 * Furthermore, embedding also allows us to construct an infinitely long structure, in theory anyway.
 */
object House {
  def makeVerse(source: List[List[String]]): String = {
    def separator(line: List[String]): String = if (line.contains("Jack built.")) " " else "\n"

    (1 to source.length)
      .map(number =>
        source
          .take(number)
          .map(line => line.mkString(" the ", s"${separator(line)}that ", ""))
          .reverse
          .mkString("This is", "", "\n")
      ).mkString("\n")
  }
}
