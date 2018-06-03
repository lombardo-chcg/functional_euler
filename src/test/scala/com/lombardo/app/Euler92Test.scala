package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler92Test extends EulerTestBase {
  val e = new Euler92

  it should "have good helpers" in {
    e.squareDigitsAndAdd(44) should be(32)
    e.squareDigitsAndAdd(85) should be(89)
    e.`1or89`(44) should be(1)
    e.`1or89`(85) should be(89)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      println(e.solve)
    }
  }
}