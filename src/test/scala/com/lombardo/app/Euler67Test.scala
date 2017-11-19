package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler67Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler67

  it should "have good helpers" in {
    e.getTriangle("/p067_triangle.txt")(5) should be(List(10, 51, 87, 86, 81))
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(e.getTriangle("/p067_triangle.txt")) should be(Map(1 -> List(7273)))
    }
  }
}