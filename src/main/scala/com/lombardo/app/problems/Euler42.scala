package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers._

import scala.io.Source

class Euler42 {
  def triangleNums(max: Int): Stream[Int] = Stream.from(1).take(max).map(computeTriangle)
  def triNumsUnder(max: Int): Stream[Int] = {
    Stream.from(1).map(computeTriangle).takeWhile(_ < max)
  }
  def getNumericalValue(s: String): Int = {
    s.toCharArray.map(_.toInt - 64).sum
  }
  def readFile(file: String): Iterator[String] = {
    Source.fromInputStream(getClass.getResourceAsStream(file)).getLines
  }
  def solve:Int = {
    val listOfWords = readFile("/p042_words.txt").mkString.split(",").map(_.replaceAll("\"", "")).toList
    val maxWordValue = getNumericalValue(listOfWords.maxBy(_.length).split("").map(_ => "Z").mkString)
    val triNumMap = triNumsUnder(maxWordValue + 1).foldLeft(Map.empty[Int, Boolean])((acc, cur) => acc + (cur -> true))
    listOfWords.map(getNumericalValue).count(triNumMap.contains)
  }
}
