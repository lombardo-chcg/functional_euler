package com.lombardo.app.problems

import com.lombardo.app.helpers.PrimeCalculator

class Euler46 {
  val pc = new PrimeCalculator
  val primeList = pc.primesUnder(1000000)

  def conject(n: Int) = {
    if(n % 2 == 0) true
    else {
      var passes = false
      val primes = primeList.filter(_ <= n)
      val squareCandidates = (1 to n).toList
      primes.foreach(p => {
        squareCandidates.foreach(sqC => {
          if (!passes) {
          println(s"n = $n, $p + 2 * $sqC.squared = ${p + (2 * (sqC * sqC))}")
            if (n == p + (2 * (sqC * sqC))) passes = true
          }
        })
      })
      passes
    }
  }
  def solve:Int = {
    var c = 9
    var found = false
    while (!found) {
      val cur = conject(c)
      println(cur, c)
      if(!cur) found = true
      c = c+2
    }
    c
  }
}
