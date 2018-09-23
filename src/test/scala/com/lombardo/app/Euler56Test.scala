package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler56Test extends EulerTestBase {
  val e = new Euler56

  it should "have good helpers" in {
    val googol = BigInt(10).pow(100)
    val `two-hundred zeros` = BigInt(100).pow(100)
    e.getSumOfDigits(googol) should be(BigInt(1))
    e.getSumOfDigits(`two-hundred zeros`) should be(BigInt(1))
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.imperative should be(BigInt(972))
      e.solve should be(BigInt(972))
    }
  }
}