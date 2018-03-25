package com.lombardo.app

import com.lombardo.app.helpers.{PrimeCalculator, Utils}
import com.lombardo.app.problems.Euler37

class Euler37Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator

  it should "have good helpers" in {
    implicit val lowPrimes = pc.primesUnder(100000)
    val e = new Euler37
    e.leftToRightPrime(3797) should equal(true)
    e.rightToLeftPrime(3797) should equal(true)
  }

  it should "solve" in {
    Utils.time("Euler37 solve") {
      implicit val lowPrimes = Utils.time("Euler37 get primesUnder(1000000)") {
        pc.primesUnder(1000000)
      }
      val e = new Euler37
      Utils.time("Euler37 inner run time") {
        e.solve should be(748317)
      }
    }
  }
}