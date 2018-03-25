package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler23Test extends EulerTestBase {
    val e = new Euler23

      it should "have good helpers" in {
        List(1,2,3,5,6,10,11).foreach(i => e.isAbundant(i) should be(false))
        e.isAbundant(28) should be(false)
        e.isAbundant(12) should be(true)
      }

      it should "solve" in {
        time(s"${getClass.getSimpleName.replace("Test", "")}") {
            e.solve should be(4179871)
          }
      }
  }
