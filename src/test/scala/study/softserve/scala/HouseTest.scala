package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class HouseTest extends AnyFunSuite with Matchers {
  test("Verse") {
    val source: List[List[String]] = List(
      List("house", "Jack built."),
      List("malt", "lay in"),
      List("rat", "ate"),
      List("cat", "killed"),
      List("dog", "worried"),
      List("cow with the crumpled horn", "tossed"),
      List("maiden all forlorn", "milked"),
      List("man all tattered and torn", "kissed"),
      List("priest all shaven and shorn", "married"),
      List("rooster that crowed in the morn", "woke"),
      List("farmer sowing his corn", "kept"),
      List("horse and the hound and the horn", "belonged to")
    )

    val expected: String = "This is the house that Jack built.\n\nThis is the malt\nthat lay in the house that Jack built.\n\nThis is the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the rooster that crowed in the morn\nthat woke the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the farmer sowing his corn\nthat kept the rooster that crowed in the morn\nthat woke the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n\nThis is the horse and the hound and the horn\nthat belonged to the farmer sowing his corn\nthat kept the rooster that crowed in the morn\nthat woke the priest all shaven and shorn\nthat married the man all tattered and torn\nthat kissed the maiden all forlorn\nthat milked the cow with the crumpled horn\nthat tossed the dog\nthat worried the cat\nthat killed the rat\nthat ate the malt\nthat lay in the house that Jack built.\n"
    val actual: String = House.makeVerse(source);

    actual shouldBe expected
  }
}
