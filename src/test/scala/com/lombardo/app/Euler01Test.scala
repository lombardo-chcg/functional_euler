package com.lombardo.app
import com.lombardo.app.problems._

class Euler01Test extends EulerTestBase {
  it should "solve" in {
    val e = new Euler01
    e.solve should equal(233168)
  }
}
