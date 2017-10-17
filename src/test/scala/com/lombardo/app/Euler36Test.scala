package com.lombardo.app
import com.lombardo.app.problems.Euler36
import org.scalatest.{FlatSpec, Matchers}

class Euler36Test extends FlatSpec with Matchers {
  it should "solve" in {
    val e36 = new Euler36
    e36.solve(1000000 - 1) should equal(872187)
  }
}