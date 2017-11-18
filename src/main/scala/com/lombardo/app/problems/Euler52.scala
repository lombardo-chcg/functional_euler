package com.lombardo.app.problems

class Euler52 {
  def getCanonical(n: Int): String = n.toString.split("").sorted.mkString
  def allAreSame(n: Int): Boolean = {
    (2 to 6).map(_ * n).map(getCanonical).distinct.size == 1
  }
  
  def solve: Option[Int] = {
    Stream.from(1).find(allAreSame)
  }
}
