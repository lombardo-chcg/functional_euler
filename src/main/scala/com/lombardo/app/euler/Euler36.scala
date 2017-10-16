package com.lombardo.app.euler

object Helpers {
  def isPalindrome(w: String): Boolean = {
    w match {
      case _ if w.length == 1 => true
      case _ if w.head != w.last => false
      case _ if w.length == 2 && w.head == w.last => true
      case _ => this.isPalindrome(w.tail.dropRight(1))
    }
  }
}

class Euler36 {
  import com.lombardo.app.objs.Helpers.isPalindrome

  def allPalindromes(n: Int): List[Int] = {
    (1 until n).filter(x => {
      val base10 = x.toString
      val base2 = x.toBinaryString
      if (base2.startsWith("0")) false
      else isPalindrome(base10) && isPalindrome(base2)
    }).toList
  }

  def solve(n: Int): Int = allPalindromes(n).reduce(_ + _)
}
