package com.lombardo.app.problems

class Euler23 {
  def isAbundant(n: Int): Boolean = {
    divisors(n).sum > n
  }

  def divisors(n: Int): List[Int] = {
    (1 to n / 2).filter(i => n % i == 0).toList
  }

  def solve: Int = {
    val MAX = 28123
    val abundantNums: IndexedSeq[Int] = (1 to MAX).filter(isAbundant)

    // SIEVE
    val numbersThatAreSumOfTwoAbundant = abundantNums.flatMap(a => {
      val multiplesOfCurrentAbNumber: IndexedSeq[Int] = abundantNums.takeWhile(_ <= (MAX - a)).map(i => i + a)
      multiplesOfCurrentAbNumber
    })

    val numbersThatAreSumOfTwoAbundantLookupMap = numbersThatAreSumOfTwoAbundant.distinct.zipWithIndex.toMap

    (1 to 28123).filterNot(i => numbersThatAreSumOfTwoAbundantLookupMap.contains(i)).sum
  }

}
