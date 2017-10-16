package com.lombardo.app
import com.lombardo.app.euler._
import org.scalatest.{FlatSpec, Matchers}

class Euler01Test extends FlatSpec with Matchers {
  it should "solve" in {
    val e = new Euler01
    e.solve should equal(233168)
  }
}
