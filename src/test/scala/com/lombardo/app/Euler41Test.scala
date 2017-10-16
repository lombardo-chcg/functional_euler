package com.lombardo.app

import com.lombardo.app.euler.Euler41
import com.lombardo.app.objs.PrimeCalculator
import com.lombardo.app.objs.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class Euler41Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator

  it should "have good helpers" in {
    val e = new Euler41
    e.isPandigital(2143) should equal(true)
    e.isPandigital(21423) should equal(false)
    e.isPandigital(1234567893) should equal(false)
  }

  it should "solve" in {
    time(s"$getClass SOLVE") {
      val e = new Euler41
      e.solve should equal(7652413)
    }
  }
}