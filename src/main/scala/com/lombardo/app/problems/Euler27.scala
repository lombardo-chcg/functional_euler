package com.lombardo.app.problems

import com.lombardo.app.helpers.PrimeCalculator

case class LongestFound(count: Int, a: Int, b: Int)

class Euler27 {
  import Helper28._

  val pc = new PrimeCalculator
  val primeMap = pc.primeMap(pc.primesUnder(1000000))

  def exampleFormula1(n: Int): Int = {
    n.squared + n + 41
  }

  def solve2 = {
    Stream.from(0).takeWhile(n => primeMap.contains(exampleFormula1(n))).size
  }

  def exampleFomula2(n: Int) = {
    n.squared - (79 * n) + 1601
  }

  def solve3 = Stream.from(0).takeWhile(n => primeMap.contains(exampleFomula2(n))).size

  def solutionFormula(n: Int, a: Int, b: Int): Int = {
    n.squared + (a * n) + b
  }

  def imperativeSolve:Int = {
    // imperative
    var longestFound: (Int, Int, Int) = (0,0,0)
    for { a <- -1000 to 999 } {
      for { b <- -1000 to 1000 } {
        val n = Stream.from(0).takeWhile(n => primeMap.contains(solutionFormula(n,a,b))).size
        if (n > longestFound._1) longestFound = (n,a,b)
      }
    }
    longestFound._2 * longestFound._3

  }

  def functionalSolve: Int = {
    // write once, read never
    (for {
      a <- -1000 to 999
      b <- -1000 to 999
      n <- Stream.from(0).takeWhile(n => primeMap.contains(solutionFormula(n,a,b)))
    } yield (n, a, b)).foldLeft((0,0))((acc, cur) => if (cur._1 > acc._1) (cur._1, (cur._2 * cur._3)) else acc)._2
  }
}
