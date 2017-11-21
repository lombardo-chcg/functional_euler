package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler52Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler52

  it should "have good helpers" in {
    (e.getCanonical(125874) == e.getCanonical(251748)) should be(true)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve.get should be(142857)
    }
  }
}