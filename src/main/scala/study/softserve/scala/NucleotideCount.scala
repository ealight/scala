package study.softserve.scala

object NucleotideCount {
  def findNucleotide(source: String): Either[String, Map[Char, Int]] = {
    val nucleotides: List[Char] = List('A', 'C', 'G', 'T')

    if (source.forall("ACTG".contains(_))) {
      Right(nucleotides.foldLeft(Map.empty[Char, Int]) { (map, nucleotide) =>
        map + (nucleotide -> source.count(_ == nucleotide))
      })
    }
    else {
      Left("Line contains bad nucleotide")
    }
  }
}
