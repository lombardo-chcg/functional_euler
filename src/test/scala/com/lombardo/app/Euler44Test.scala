package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler44Test extends EulerTestBase {
  val e = new Euler44

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      // started with 10,000 and moved max down from there
      val max = 2500L
      val result = e.solve(max)
      result should be((7042750,1560090))
      (result._1 - result._2) should be(5482660L)
    }
  }
}