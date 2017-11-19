package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler18Test extends FlatSpec with Matchers {
  val e = new Euler18
  val sampleInput = Map(
    1 -> List(3),
    2 -> List(7, 4),
    3 -> List(2, 4, 6),
    4 -> List(8, 5, 9, 3)
  )

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve(sampleInput)(1).head should be(23)
      e.solve(e.readTriangleFromFile("/p018_triangle.txt")) should be(Map(1 -> List(1074)))
    }
  }
}