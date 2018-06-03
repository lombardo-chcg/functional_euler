package com.lombardo.app.problems

class Euler92 {

  def squareDigitsAndAdd(n: Int): Int = {
    n.toString.split("").map(d => d.toInt * d.toInt).sum
  }

  val cache = collection.mutable.Map[Int, Int]()

  def `1or89`(n: Int) = {
    var searchingForLoop = true
    var cur = n
    while(searchingForLoop) {
      val next = squareDigitsAndAdd(cur)
      if (cache.contains(next)) {
        cur = cache(next)
        searchingForLoop = false
      } else {
        if (next == 89 | next == 1) {
          cache(n) = next
          searchingForLoop = false
        }
        cur = next
      }
    }
    cur
  }

  def solve:Int = {
    var num89s = 0
    (1 to 10000000).foreach(n => {
      if (`1or89`(n) == 89) num89s = num89s + 1
    })
    num89s
  }
}
