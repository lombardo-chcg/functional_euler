package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler39Test extends EulerTestBase {
  val e = new Euler39

  it should "have good helpers" in {
    e.numSolutions(120) should be(3)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(840)
    }
  }
}