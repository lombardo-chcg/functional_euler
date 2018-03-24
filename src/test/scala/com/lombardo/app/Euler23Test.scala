package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._
import org.scalatest.{FlatSpec, Matchers}

class Euler23Test extends FlatSpec with Matchers {
    val e = new Euler23

      it should "have good helpers" in {
        List(1,2,3,5,6,10,11).foreach(i => e.isAbundant(i) should be(false))
        e.isAbundant(28) should be(false)
        e.isAbundant(12) should be(true)
      }

      it should "solve" in {
        time(s"${getClass.getSimpleName.replace("Test", "")}") {
//            println(e.solve)
          }
      }
  }
