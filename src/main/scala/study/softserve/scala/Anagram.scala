package study.softserve.scala

/**
 * An anagram is a rearrangement of letters to form a new word.
 * Given a word and a list of candidates, select the sublist of anagrams of the given word.
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana"
 * the program should return a list containing "inlets".
 */
object Anagram {
  def find(source: List[String], given: String): List[String] =
    source.filter(_.toLowerCase.sorted == given.toLowerCase.sorted)
}
