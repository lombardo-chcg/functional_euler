package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler29Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler29

  it should "have good helpers" in {
    e.get(5) should be(List(2,3,4,5))
    e.getIntegerCombos(2, 5) should be(List(4,8,16,32))
    e.getIntegerCombos(3, 5) should be(List(9,27,81,243))
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")} solve") {
      e.solve(5).sorted should be(List(4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125))
      e.solve(5).size should be(15)
      e.solve(100).size should be(9183)
    }
  }
}