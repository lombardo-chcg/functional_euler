package com.lombardo.app.problems

import com.lombardo.app.helpers.PrimeCalculator

class Euler49(implicit val pc: PrimeCalculator) {
  def canonicalPrimeMap(upperBound: Int): Map[String, List[Int]] = {
    pc.primesUnder(upperBound).groupBy(_.toString.split("").sorted.mkString)
  }

  def isArithmeticSequence(input: List[Int]): Boolean = {
    input.sliding(2).toList.map(p => p(1) - p.head).distinct.size == 1
  }

  def solve: List[List[Int]] = {
    canonicalPrimeMap(10000)
      .flatMap(p => p._2.combinations(3).filter(isArithmeticSequence)).toList
  }
}
