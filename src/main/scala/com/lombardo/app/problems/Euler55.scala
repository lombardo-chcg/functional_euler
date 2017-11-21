package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers._

class Euler55 {
  def getReverse(n: BigInt): BigInt = BigInt(n.toString.reverse)

  def isLychrel(n: BigInt, c: Int = 0): Boolean = {
    if (c == 50) true
    else if (isPalindrome(n + getReverse(n))) false
    else isLychrel(n + getReverse(n), c + 1)
  }
  
  def solve(max: Int):Int = {
    Stream.from(1).take(max).count(i => isLychrel(BigInt(i)))
  }
}
