package com.lombardo.app.helpers

import scala.io.Source

object Helpers {
  def isPalindrome(w: String): Boolean = {
    w match {
      case _ if w.length == 1 => true
      case _ if w.head != w.last => false
      case _ if w.length == 2 && w.head == w.last => true
      case _ => this.isPalindrome(w.tail.dropRight(1))
    }
  }

  def computeTriangle(n: Int): Int = ((0.5 * n) * (n + 1)).toInt
  def computePentagonal(n: Int): Int = (n * (3 * n - 1)) / 2
  def computeHexagonal(n: Long): Long = n * (2 * n - 1)

//  https://en.wikipedia.org/wiki/Pentagonal_number#Tests_for_pentagonal_numbers
  def isPentagonal(n: Long): Boolean = {
    ((Math.sqrt(24 * n + 1) + 1) / 6) % 1 == 0
  }

//  https://en.wikipedia.org/wiki/Hexagonal_number#Test_for_hexagonal_numbers
  def isHexagonal(n: Int): Boolean = {
    ((Math.sqrt((8 * n) + 1) + 1) / 4) % 1 == 0
  }

  def readFile(file: String): Iterator[String] = {
    Source.fromInputStream(getClass.getResourceAsStream(file)).getLines
  }
}