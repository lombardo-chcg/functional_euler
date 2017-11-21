package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers._

class Euler44 {
  def solve(max: Long): (Long, Long) = {
    val list = (1L to max).map(computePentagonal)
    list.flatMap(a => {
      list.flatMap(b => {
        if (isPentagonal(a + b) && isPentagonal(a - b)) Some((a, b))
        else None
      })
    }).head
  }
}
