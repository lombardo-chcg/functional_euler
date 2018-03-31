package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler27Test extends EulerTestBase {
  val e = new Euler27

  it should "have good helpers" in {
    e.solve2 should be(40)
    e.solve3 should be(80)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.imperativeSolve should be(-59231)
      e.functionalSolve should be(-59231)
    }
  }
}