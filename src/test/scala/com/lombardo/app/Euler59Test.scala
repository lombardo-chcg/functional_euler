package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler59Test extends EulerTestBase {
  val e = new Euler59

  it should "have good helpers" in {
    e.encrypt(List(65), List(42)) should be(List(107))
    e.encrypt(List(107), List(42)) should be(List(65))
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(107359)
    }
  }
}