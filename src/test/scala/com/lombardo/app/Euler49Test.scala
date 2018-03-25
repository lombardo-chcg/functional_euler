package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems.Euler49
import org.scalatest.{FlatSpec, Matchers}

class Euler49Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler49
  it should "have good helpers" in {
    e.isArithmeticSequence(List(1487, 4817, 8147)) should be (true)
    e.isArithmeticSequence(List(1487, 4817, 8148)) should be (false)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should contain(List(1487, 4817, 8147))
      e.solve should contain(List(2969, 6299, 9629))
    }
  }
}