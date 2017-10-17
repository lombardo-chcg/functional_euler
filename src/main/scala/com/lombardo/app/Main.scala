package com.lombardo.app

import com.lombardo.app.helpers.PrimeCalculator

object Main {
  def main(args: Array[String]): Unit = {
    val pc = new PrimeCalculator
    val primes = pc.primesUnder(10)
    println(pc.primeFactors(7, primes))
  }
}
