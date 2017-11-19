package com.lombardo.app.problems
import com.lombardo.app.helpers.Helpers._

class Euler45 {
  //  "Every hexagonal number is a triangular number"
  //  https://en.wikipedia.org/wiki/Hexagonal_number
  def solve(startingPoint: Int): Long = {
    Stream.from(startingPoint)
      .map(i => computeHexagonal(i.toLong))
      .find(isPentagonal) match {
      case Some(i) => i
      case None => throw new Exception("Euler45 solve threw")
    }
  }
}
