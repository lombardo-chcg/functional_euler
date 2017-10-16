package com.lombardo.app.euler

import com.lombardo.app.objs.PrimeCalculator
import com.lombardo.app.objs.Utils.time

class Euler41(implicit val pc: PrimeCalculator) {

  def isPandigital(n: Int): Boolean = {
    val str = n.toString
    if (str.size > 9) false
    else {
      val matcher = for (i <- 1 to str.size) yield i.toString
      matcher == str.split("").sorted.toSeq
    }
  }

  def solve: Int = {
    // 7654321 is a tuned upper bound based on multiple iterations, started with a much higher number and
    val p = time("primesUnder(7654321)") { pc.primesUnder(7654321) }
    time("filter(isPandigital).last"){
      p.filter(isPandigital).last
    }
  }
}
