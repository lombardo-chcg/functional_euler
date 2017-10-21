package com.lombardo.app.problems

class Euler43 {
  val offset = -1

  def extractIntFromSeq(a: Int, b: Int, c: Int)(implicit col: IndexedSeq[String]): Int = {
    s"${col(a + offset)}${col(b + offset)}${col(c + offset)}".toInt
  }

  def passesDivisibilityTests(v: IndexedSeq[String]): Boolean = {
    implicit val col = v
    extractIntFromSeq(2, 3, 4) % 2 == 0 &&
    extractIntFromSeq(3, 4, 5) % 3 == 0 &&
    extractIntFromSeq(4, 5, 6) % 5 == 0 &&
    extractIntFromSeq(5, 6, 7) % 7 == 0 &&
    extractIntFromSeq(6, 7, 8) % 11 == 0 &&
    extractIntFromSeq(7, 8, 9) % 13 == 0 &&
    extractIntFromSeq(8, 9, 10) % 17 == 0
  }

  def solve(): Long = {
    (0 to 9).map(_.toString)
      .permutations
      .filter(i => !(i(0) == "0") && passesDivisibilityTests(i))
      .map(_.mkString.toLong)
      .sum
  }
}
