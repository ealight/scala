package study.softserve.scala

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class NucleotideTest extends AnyFunSuite with Matchers{

  test("Right Nucleotide Line") {
    val source: String = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"

    val expected = Right(Map(
      'A' -> 20,
      'C' -> 12,
      'G' -> 17,
      'T' -> 21
    ))

    val actual = NucleotideCount.findNucleotide(source)

    actual shouldBe expected
  }

  test("Wrong Nucleotide Line") {
    val source: String = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTbGGATTAAAAAAAGAGTGTCTGATAGCAGC"

    val expected = Left("Line contains bad nucleotide")

    val actual = NucleotideCount.findNucleotide(source)

    actual shouldBe expected
  }

}
