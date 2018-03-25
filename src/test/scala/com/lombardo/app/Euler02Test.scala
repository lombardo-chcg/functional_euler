package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler02Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler02

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(4000000) should be(4613732)
    }
  }
}