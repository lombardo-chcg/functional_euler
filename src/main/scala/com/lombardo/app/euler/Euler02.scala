package com.lombardo.app.euler

class Euler02 {

  def fibSequence(max: Int, sequence: List[Int] = List(0,1)) : List[Int] = {
    if (sequence.last >= max) sequence.filter(_ <= max)
    else fibSequence(max, sequence :+ sequence.takeRight(2).sum)
  }

  def solve(n: Int):Int = {
      fibSequence(n).filter((num) => num % 2 != 0).sum
  }
}
