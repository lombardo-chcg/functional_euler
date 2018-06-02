package com.lombardo.app.problems

class Euler97 {
  
  def solve:String = {
    val x = BigInt(28433)
    val y = BigInt(2).pow(7830457)
    (x * y + 1).toString.takeRight(10)
  }
}
