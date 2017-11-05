package com.lombardo.app.problems

class Euler40 {
  def makeString(n: Int): String = {
    Stream.from(1).take(n).map(_.toString).mkString("")
  }

  def getNth(n: Int)(implicit s: String): Int = {
    s(n - 1).toString.toInt
  }
  
  def solve:Int = {
    implicit val s = makeString(1000000)
    List(
      getNth(1),
      getNth(10),
      getNth(100),
      getNth(1000),
      getNth(10000),
      getNth(100000),
      getNth(1000000)
    ).reduce(_ * _)
  }
}
