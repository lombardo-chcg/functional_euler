package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler24Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler24

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be("2783915460")
    }
  }
}