package com.lombardo.app.problems

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Euler92 {
  def squareDigitsAndAdd(n: Int): Int = {
    n.toString.split("").map(d => d.toInt * d.toInt).sum
  }

  @tailrec
  private def findChainTerminator(i: Int, chain: ListBuffer[Int], cache: mutable.Map[Int, Int]): Int = {
    val nextLink = squareDigitsAndAdd(i)
    if (cache.contains(nextLink)) {
      val cachedTerminator = cache(nextLink)
      chain.foreach(i => cache(i) = cachedTerminator)
      cachedTerminator
    }
    else if (nextLink == 89 | nextLink == 1) {
      cache(i) = nextLink
      nextLink
    }
    else {
      chain += nextLink
      findChainTerminator(nextLink, chain, cache)
    }
  }

  def solve:Int = {
    val terminatorCache = mutable.Map[Int, Int]()
    (1 to 10000000).foldLeft(0)((acc, cur) => {
      val chain = new ListBuffer[Int]()
      val chainTerminator = findChainTerminator(cur, chain, terminatorCache)
      if (chainTerminator == 89) acc + 1 else acc
    })
  }
}
