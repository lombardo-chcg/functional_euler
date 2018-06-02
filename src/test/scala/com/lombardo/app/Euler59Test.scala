package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler59Test extends EulerTestBase {
  val e = new Euler59

  it should "have good helpers" in {
    e.encrypt(65, 42) should be(107)
    e.encrypt(107, 42) should be(65)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
//      println(e.solve)
    }
  }
}