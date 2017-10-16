package com.lombardo.app.objs

import scala.collection.mutable.ArrayBuffer

object PrimeCalculator {
  val pc = new PrimeCalculator
  pc
}
case class InvalidInputException() extends Exception
case class SmartPrime(n: Int, nth: Int, next: Int)

class PrimeCalculator {
  def primesUnder(n: Int): List[Int] = {
    if (n <= 1) List()
    else {
      val A = ArrayBuffer.fill(n + 1)(true)
      for (i <- 2 to Math.sqrt(n).toInt if A(i)) {
        for (j <- (i * i) to n by i) {
          A.update(j, false)
        }
      }
      (for (m <- A.indices if A(m)) yield m).drop(2).takeWhile(_ < n).toList
    }
  }

  def isPrime(x: Int): Boolean = {
    if (x == 2) true
    else if (x % 2 == 0) false
    else primesUnder(x + 1).contains(x)
  }

  def nthPrime(n: Int): Int = {
    val upperBound = (n * Math.log(n) / Math.log(2)).toInt
    primesUnder(upperBound)(n-1)
  }

  def primeMap(primes: List[Int]): Map[Int, Boolean] = {
    primes.foldLeft(Map.empty[Int, Boolean])((acc, cur) => acc + (cur -> true))
  }

  def primeFactors(n: Int, primeList: List[Int]): List[Int] = {
    if (n <= 1) List()
    else {
      val firstPrimeFactor = primeList.view.find(n % _ == 0) match {
        case Some(i) => i
        case _ => throw new InvalidInputException
      }
      List(firstPrimeFactor) ++ primeFactors( n / firstPrimeFactor, primeList)
    }
  }
}
