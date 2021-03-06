package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers.isPalindrome

class Euler36 {

  def allPalindromes(n: Int): List[Int] = {
    Stream.from(1).take(n).filter(x => {
      val base10 = x.toString
      val base2 = x.toBinaryString
      if (base2.startsWith("0")) false
      else isPalindrome(base10) && isPalindrome(base2)
    }).toList
  }

  def solve(n: Int): Int = allPalindromes(n).reduce(_ + _)
}
