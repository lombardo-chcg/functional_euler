package com.lombardo.app

import com.lombardo.app.problems.Euler47
import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class Euler47Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler47

  it should "solve" in {
    time(s"$getClass solve") {
      // the upper bound input here is purely based on educated guesses
      e.solve(2, 100) should be(List(14,15))
      e.solve(3, 1000) should be(List(644,645,646))
      e.solve(4, 140000) should be(List(134043, 134044, 134045, 134046))
    }
  }
}