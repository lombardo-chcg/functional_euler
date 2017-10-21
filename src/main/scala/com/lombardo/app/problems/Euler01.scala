package com.lombardo.app.problems

class Euler01 {
  
  def solve:Int = {
    Stream.from(1).take(999).toList.filter(num => if (num % 3 == 0 | num % 5 == 0) true else false).sum
  }
}
