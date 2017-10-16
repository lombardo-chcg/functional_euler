package com.lombardo.app.objs

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
