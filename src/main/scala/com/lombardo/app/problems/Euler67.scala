package com.lombardo.app.problems

class Euler67 {
  val euler18 = new Euler18

  def getTriangle(fileLoc: String): Map[Int, List[Int]] = {
    euler18.readTriangleFromFile(fileLoc)
  }
  def solve(i: Map[Int, List[Int]]): Map[Int, List[Int]] = {
    euler18.solve(i)
  }
}
