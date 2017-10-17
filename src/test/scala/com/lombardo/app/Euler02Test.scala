package com.lombardo.app

import com.lombardo.app.problems._
import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class Euler02Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler02

  it should "solve" in {
    time(s"$getClass solve") {
      e.solve(4000000) should be(4613732)
    }
  }
}