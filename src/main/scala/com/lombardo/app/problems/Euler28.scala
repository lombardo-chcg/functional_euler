package com.lombardo.app.problems
object Helper28 {
  implicit class SquareableInt(val i: Int) extends AnyVal {
    def squared = i*i
  }
}

class Euler28 {
import Helper28._


  def topRight(n: Int) = {
    val boxWidth = (2 * n + 1)
    boxWidth.squared
  }
  def topLeft(n: Int) = topRight(n) - (2*n)
  def bottomLeft(n: Int) = topRight(n) - (4*n)
  def bottomRight(n: Int) = topRight(n) - (6*n)

  def sumRing(n: Int) = {
    if (n==0) 1
    else topRight(n) + topLeft(n) + bottomLeft(n) + bottomRight(n)
  }

  def sumRings(max: Int) = {
    if (max==0) 1
    else (1 to max).map(sumRing).sum + sumRing(0)
  }

  def solve:Int = {
    sumRings(500)
  }
}
