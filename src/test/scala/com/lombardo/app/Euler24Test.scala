package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler24Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler24

  it should "solve" in {
    time(s"$getClass solve") {
      e.solve should be("2783915460")
    }
  }
}