package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler31Test extends EulerTestBase {
  val e = new Euler31

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(73682)
    }
  }
}