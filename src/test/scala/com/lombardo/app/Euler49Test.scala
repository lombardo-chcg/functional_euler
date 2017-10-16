package com.lombardo.app

import com.lombardo.app.euler.Euler49
import com.lombardo.app.objs.PrimeCalculator
import com.lombardo.app.objs.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class Euler49Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler49
  it should "have good helpers" in {
    e.isArithmeticSequence(List(1487, 4817, 8147)) should be (true)
    e.isArithmeticSequence(List(1487, 4817, 8148)) should be (false)
  }

  it should "solve" in {
    time(s"$getClass solve") {
      e.solve should contain(List(1487, 4817, 8147))
      e.solve should contain(List(2969, 6299, 9629))
    }
  }
}