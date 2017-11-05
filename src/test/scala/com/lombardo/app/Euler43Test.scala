package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler43Test extends FlatSpec with Matchers {
  implicit val pc = new PrimeCalculator
  val e = new Euler43

  it should "have good helpers" in {
    implicit val seq:IndexedSeq[String] = 1406357289.toString.split("")
    e.extractIntFromSeq(2,3,4) should be(406)
    e.extractIntFromSeq(3,4,5) should be(63)
    e.extractIntFromSeq(4,5,6) should be(635)
    e.extractIntFromSeq(8,9,10) should be(289)

    e.passesDivisibilityTests(1406357289.toString.split("")) should be(true)
    e.passesDivisibilityTests(1406357288.toString.split("")) should be(false)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(16695334890L)
    }
  }
}