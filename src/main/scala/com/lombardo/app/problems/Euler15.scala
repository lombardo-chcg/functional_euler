package com.lombardo.app.problems

class Euler15 {
  // TODO: revisit this with functional data structures in mind
  // a functional solution did not present itself to me during the alloted timebox
  def runFunctional() = ???

  def runBasic(size: Int): Int = {
    def basic(x: Int, y: Int): Int = {
      if (x == size && y == size) 1
      else {
        var paths = 0
        if (x < size) paths = paths + basic(x+1, y)
        if (y < size) paths = paths + basic(x, y+1)
        paths
      }
    }
    basic(0,0)
  }

  def runWithMemoization(size: Long): Long = {
    var warehouse = Map[(Long, Long), Long]()
    def memo(x: Long, y: Long): Long = {
      if (x == size && y == size) 1L
      else {
        if (!warehouse.contains((x, y))) {
          var paths = 0L
          if (x < size) paths += memo(x+1L, y)
          if (y < size) paths += memo(x, y+1L)
          warehouse += (x,y) -> paths
        }
        warehouse((x,y))
      }
    }
    memo(0L,0L)
  }

  def solve(size: Long): Long = {
    runWithMemoization(size)
  }
}
