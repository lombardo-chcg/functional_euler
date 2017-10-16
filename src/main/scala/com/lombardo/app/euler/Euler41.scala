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
    val p = time("primesUnder(99999999)") { pc.primesUnder(7654321) }
    time("filter(isPandigital).last"){
      p.filter(isPandigital).last
    }
  }
}
