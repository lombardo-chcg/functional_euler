package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler45Test extends EulerTestBase {
  val e = new Euler45

  it should "have good helpers" in {
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(2) should be(40755)
      e.solve(144) should be(1533776805)
    }
  }
}