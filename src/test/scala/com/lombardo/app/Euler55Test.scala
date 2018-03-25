package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler55Test extends EulerTestBase {
  val e = new Euler55

  it should "have good helpers" in {
    47 + e.getReverse(47) should be(121)
    349 + e.getReverse(349) should be(1292)
    e.getReverse(4213) should be(3124)
    e.getReverse(BigInt("4668731596684224866951378664")) should be(BigInt("4668731596684224866951378664"))
    e.isLychrel(47) should be(false)
    e.isLychrel(349) should be(false)
    e.isLychrel(10677) should be(true)
    e.isLychrel(196) should be(true)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(10000 - 1) should be(249)
    }
  }
}