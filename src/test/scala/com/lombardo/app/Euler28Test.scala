package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler28Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler28

  it should "have good helpers" in {
    e.topRight(1) should be(9)
    e.topLeft(1) should be(7)
    e.bottomLeft(1) should be (5)
    e.bottomRight(1) should be(3)

    e.topRight(2) should be(25)
    e.topLeft(2) should be(21)
    e.bottomLeft(2) should be (17)
    e.bottomRight(2) should be(13)

    e.sumRing(0) should be(1)
    e.sumRings(2) should be(101)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(669171001)
    }
  }
}