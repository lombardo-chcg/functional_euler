package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers

class Euler18 {
  def readTriangleFromFile(fileLoc: String): Map[Int, List[Int]] = {
    Helpers.readFile(fileLoc).zipWithIndex.foldLeft(
      Map.empty[Int, List[Int]])((acc, cur) => {
      cur match {
        case (line, idx) => acc + (idx+1 -> line.split(" ").map(_.toInt).toList)
      }
    })
  }

  def solve(i: Map[Int, List[Int]]): Map[Int, List[Int]] = {
    if (i.size == 1) i
    else {
      val targetRowNum = i.size - 1
      val lastRowNum = i.size
      val newLastRow = i(targetRowNum).zipWithIndex.map({ case (num, idx) =>
        num + Math.max(i(lastRowNum)(idx), i(lastRowNum)(idx+1))
      })
      solve((i - lastRowNum) + (targetRowNum -> newLastRow))
    }
  }
}
