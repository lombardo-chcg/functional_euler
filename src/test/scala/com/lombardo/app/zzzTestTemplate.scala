package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class zzzTestTemplate extends EulerTestBase {
  val e = new Euler01

  it should "have good helpers" in {
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
    }
  }
}