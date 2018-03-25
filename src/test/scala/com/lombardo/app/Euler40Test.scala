package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler40Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler40

  it should "have good helpers" in {
    e.makeString(21) should be ("123456789101112131415161718192021")
    implicit val s = e.makeString(21)
    e.getNth(12) should be(1)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(210)
    }
  }
}