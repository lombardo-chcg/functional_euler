package com.lombardo.app
import com.lombardo.app.problems._
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}

class Euler01Test extends EulerTestBase {
  it should "solve" in {
    val e = new Euler01
    e.solve should equal(233168)
  }
}
