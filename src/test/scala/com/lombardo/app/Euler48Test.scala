package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems.Euler48

class Euler48Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler48

  it should "have good helpers" in {
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(10).toString should be("10405071317")
      e.solve(1000).toString.takeRight(10) should be("9110846700")
    }
  }
}