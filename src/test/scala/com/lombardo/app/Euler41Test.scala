package com.lombardo.app

import com.lombardo.app.problems.Euler41
import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class Euler41Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler41

  it should "have good helpers" in {
    e.isPandigital(2143) should equal(true)
    e.isPandigital(21423) should equal(false)
    e.isPandigital(1234567893) should equal(false)
  }

  it should "solve" in {
    time(s"$getClass SOLVE") {
      e.solve should equal(7652413)
    }
  }
}