package com.lombardo.app

import com.lombardo.app.problems._
import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class zzzTestTemplate extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler41

  it should "have good helpers" in {
  }

  it should "solve" in {
    time(s"$getClass solve") {
    }
  }
}