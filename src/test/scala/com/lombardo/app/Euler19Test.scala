package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler19Test extends FlatSpec with Matchers {
  val e = new Euler19

  it should "have good helpers" in {
    e.isLeapYear(2064) should be(true)
    e.isLeapYear(1912) should be(true)
    e.isLeapYear(1913) should be(false)
    e.isLeapYear(2000) should be(true)
    e.isLeapYear(1900) should be(false)
  }

  it should "solve" in {
    time(s"e19.imperativeStyle") {
      e.imperativeStyle should be(171)
    }
    time(s"e19.useJavaLocalDate") {
      e.solveJavaLocalDate.size should be(171)
    }
    time(s"e19.tryItFun") {
      e.useMethodsInsteadOfGenerators.size should be(171)
    }
  }
}