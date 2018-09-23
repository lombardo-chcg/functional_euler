package com.lombardo.app.problems

class Euler56 {

  def getSumOfDigits(n: BigInt): BigInt = {
    n.toString.split("").map(BigInt(_)).sum
  }

  def imperative = {
    var acc = BigInt(0)
    (1 to 99).foreach(a => {
      (1 to 99).foreach(b => {
        val tmp = getSumOfDigits(BigInt(a).pow(b))
        if (tmp > acc) acc = tmp
      })
    })
    acc
  }

  def solve: BigInt = {
    val result: Seq[BigInt] = for {
      a <- 1 to 99
      b <- 1 to 99
    } yield getSumOfDigits(BigInt(a).pow(b))
    result.max
  }
}
