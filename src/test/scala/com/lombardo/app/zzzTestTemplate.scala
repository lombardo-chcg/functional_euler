package com.lombardo.app

import com.lombardo.app.euler.Euler41
import com.lombardo.app.objs.PrimeCalculator
import com.lombardo.app.objs.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class zzzTestTemplate extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator

  it should "have good helpers" in {
    val e = new Euler41
  }

  it should "solve" in {
    time(s"$getClass solve") {
      val e = new Euler41
    }
  }
}