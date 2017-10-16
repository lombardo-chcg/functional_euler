package com.lombardo.app.euler

import com.lombardo.app.objs.PrimeCalculator

class Euler37(implicit val primes: List[Int], val pc: PrimeCalculator) {
  private lazy val primesMap = pc.primeMap(primes)
//    primes.foldLeft(Map.empty[Int, Boolean])((acc, cur) => acc + (cur -> true))

  def solve:Int = {
    val disallowed = List(2, 3, 5, 7)
    primes.filter(
      x => leftToRightPrime(x) && rightToLeftPrime(x))
      .filter(x => !disallowed.contains(x))
      .fold(0)(_ + _)
  }

  def leftToRightPrime(x: Int): Boolean = {
    x match {
      case _ if x.toString.length == 1 && primesMap.contains(x) => true
      case _ if primesMap.contains(x) => leftToRightPrime(x.toString.tail.toInt)
      case _ => false
    }
  }

  def rightToLeftPrime(x: Int): Boolean = {
    x match {
      case _ if x.toString.length == 1 && primesMap.contains(x) => true
      case _ if primesMap.contains(x) => rightToLeftPrime(x.toString.dropRight(1).toInt)
      case _ => false
    }
  }
}
