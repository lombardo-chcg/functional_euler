package com.lombardo.app.problems

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Euler92 {
  def squareDigitsAndAdd(n: Int): Int = {
    n.toString.split("").map(d => d.toInt * d.toInt).sum
  }

  def findChainTerminatorRecursive(i: Int, chain: ListBuffer[Int], cache: mutable.Map[Int, Int]): Int = {
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
      findChainTerminatorRecursive(nextLink, chain, cache)
    }
  }

//   INITIAL IMPERATIVE SOLUTION
  val cache = mutable.Map[Int, Int]()
  def findChainTerminatorImperative(n: Int) = {
    var searchingForLoop = true
    var cur = n
    val chain = new ListBuffer[Int]()

    while(searchingForLoop) {
      val next = squareDigitsAndAdd(cur)
      if (cache.contains(next)) {
        cur = cache(next)
        chain.foreach(i => cache(i) = cur)
        searchingForLoop = false
      } else {
        if (next == 89 | next == 1) {
          cache(n) = next
          searchingForLoop = false
        }
        chain += next
        cur = next
      }
    }
    cur
  }

  def solve:Int = {
    val terminatorCache = mutable.Map[Int, Int]()
    (1 to 10000000).foldLeft(0)((acc, cur) => {
      val chain = new ListBuffer[Int]()
      val chainTerminator = findChainTerminatorRecursive(cur, chain, terminatorCache)
      if (chainTerminator == 89) acc + 1 else acc
    })
  }
}
