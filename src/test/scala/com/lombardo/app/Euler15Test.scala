package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler15Test extends EulerTestBase {
  implicit val pc = new PrimeCalculator
  val e = new Euler15

  "it" should "have good helpers" in {
  }

  "it also" should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(2L) should be(6)
      e.solve(3L) should be(20)
      e.solve(4L) should be(70)
      e.solve(10L) should be(184756)
      e.solve(20L) should be(137846528820L)
    }
  }
}