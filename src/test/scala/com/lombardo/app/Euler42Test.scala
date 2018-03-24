package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler42Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler42

  it should "have good helpers" in {
    e.triangleNums(10).toList should be(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
    e.triNumsUnder(56).toList should be(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
    e.getNumericalValue("SKY") should be(55)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(162)
    }
  }
}