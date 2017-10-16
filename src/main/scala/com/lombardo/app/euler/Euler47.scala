package com.lombardo.app.euler

import com.lombardo.app.objs.PrimeCalculator

class Euler47(implicit val pc: PrimeCalculator) {
  
  def solve(window: Int, upperBound: Int): List[Int] = {
    val primeList = pc.primesUnder(upperBound + 1)
    (1 to upperBound).toList
      .filter(p => pc.primeFactors(p, primeList).distinct.size == window)
      .sorted.sliding(window).filter(p => p.head + window-1 == p(window-1)).toList.head
  }
}
