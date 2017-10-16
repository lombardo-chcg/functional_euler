package com.lombardo.app.euler

class Euler01 {
  
  def solve:Int = {
    (1 to 999).toList.filter(num => if (num % 3 == 0 | num % 5 == 0) true else false).sum
  }
}
