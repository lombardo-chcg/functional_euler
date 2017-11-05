package com.lombardo.app.problems

import scala.math.BigInt

class Euler29 {

  def get(max: BigInt): List[BigInt] = {
    (BigInt(2) to max).toList
  }

  def getIntegerCombos(seed: BigInt, max: BigInt): List[BigInt] = {
    get(max).map(n => seed.pow(n.toInt))
  }

  def solve(max: BigInt): List[BigInt] = {
    get(max).flatMap(i => getIntegerCombos(i, max)).distinct
  }
}
