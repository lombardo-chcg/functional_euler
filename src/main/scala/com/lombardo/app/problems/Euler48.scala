package com.lombardo.app.problems

class Euler48 {
  
  def solve(max: Int): BigInt = {
    Stream.from(1).take(max).foldLeft(BigInt(0))((acc, cur) => {
      acc + BigInt(cur).pow(cur)
    })
  }
}
