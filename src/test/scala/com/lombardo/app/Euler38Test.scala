package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler38Test extends EulerTestBase {
  val e = new Euler38

  it should "have good helpers" in {
    e.maybePandigital(192) should be(Some(192384576))
    e.maybePandigital(9) should be(Some(918273645))
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(932718654)
    }
  }
}