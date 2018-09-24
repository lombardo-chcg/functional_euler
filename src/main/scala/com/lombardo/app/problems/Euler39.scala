package com.lombardo.app.problems

class Euler39 {

  def numSolutions(p: Int): Int = {
    val max = p / 2
    val result = for {
      a <- 1 to max
      b <- 2 to max
      c = math.sqrt(a * a + b * b)
      if ((a + b + c == p))
    } yield(List(a,b,c))
    result.map(_.sorted).toSet.size
  }

  def solve:Int = {
    (1 to 1000).map(p => {
      (numSolutions(p), p)
    }).max._2
  }
}
