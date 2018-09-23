package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers

class Euler38 {

  def maybePandigital(n: Int, placeInSeq: Int = 1, acc: String = ""): Option[Int] = {
    if (acc.size > 9) None
    else if (acc.size > 0 && Helpers.isPandigital(acc.toInt)) Some(acc.toInt)
    else maybePandigital(n, placeInSeq + 1, (acc + (n * placeInSeq)))
  }

  def solve:Int = {
    (1 to 10000).foldLeft(0)((acc, cur) => {
      maybePandigital(cur) match {
        case Some(panDig) => if (panDig > acc) panDig else acc
        case None => acc
      }
    })
  }
}
