package com.lombardo.app.problems

import scala.collection.mutable

class Euler31 {
  val coins = List(1, 2, 5, 10, 20, 50, 100, 200)

  def countWaysWrapper(n: Int) = {
    // a lookup map of (targetValue, largestCoinToUse) -> num ways
    implicit val lookupMap = mutable.Map.empty[(Int, Int), Int]
    countWays(n, 200)
  }

  def countWays(targetValue: Int, largestCoinToUse: Int)
               (implicit lookupMap: mutable.Map[(Int, Int), Int]): Int = {
    if (targetValue < 0) 0
    else if (targetValue == 0) 1
    else if (lookupMap.contains((targetValue, largestCoinToUse))) lookupMap((targetValue, largestCoinToUse))
    else {
      lookupMap((targetValue, largestCoinToUse)) = coins.filter(_ <= largestCoinToUse).map(coin => countWays(targetValue - coin, coin)).sum
      lookupMap((targetValue, largestCoinToUse))
    }
  }
  
  def solve:BigInt = {
    countWaysWrapper(200)
  }
}
