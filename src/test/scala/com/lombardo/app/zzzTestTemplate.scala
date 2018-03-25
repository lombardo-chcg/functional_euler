package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class zzzTestTemplate extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler41

  it should "have good helpers" in {
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
    }
  }
}