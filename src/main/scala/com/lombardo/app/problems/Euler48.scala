package com.lombardo.app.problems

class Euler48 {
  
  def solve(max: Int): BigInt = {
    (1 to max).foldLeft(BigInt(0))((acc, cur) => {
      acc + BigInt(cur).pow(cur)
    })
  }
}
