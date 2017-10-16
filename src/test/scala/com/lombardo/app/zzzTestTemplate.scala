package com.lombardo.app

import com.lombardo.app.euler._
import com.lombardo.app.objs.PrimeCalculator
import com.lombardo.app.objs.Utils.time
import org.scalatest.{FlatSpec, Matchers}

class zzzTestTemplate extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler41

  it should "have good helpers" in {
  }

  it should "solve" in {
    time(s"$getClass solve") {
    }
  }
}