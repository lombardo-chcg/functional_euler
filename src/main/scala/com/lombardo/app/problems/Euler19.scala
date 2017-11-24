package com.lombardo.app.problems

import java.time.LocalDate

class Euler19 {
  def daysInMonth(m: Int, y: Int): Int = {
    val monthToNumDaysMap = Map(
      1 -> 31,
      2 -> handleFeb(y),
      3 -> 31,
      4 -> 30,
      5 -> 31,
      6 -> 30,
      7 -> 31,
      8 -> 31,
      9 -> 30,
      10 -> 31,
      11 -> 30,
      12 -> 31
    )
    monthToNumDaysMap(m)
  }

  def tomorrow(today: String): String = {
    val week = Map(
      "Mon" -> "Tue",
      "Tue" -> "Wed",
      "Wed" -> "Thur",
      "Thur" -> "Fri",
      "Fri" -> "Sat",
      "Sat" -> "Sun",
      "Sun" -> "Mon")
    week(today)
  }

  def handleFeb(y: Int): Int = {
    if (!isLeapYear(y)) 28 else 29
  }

  def isLeapYear(y: Int): Boolean = {
    if (y % 4 == 0) {
      if (y % 100 == 0) {
        if (y % 400 == 0) true
        else false
      } else true
    } else false
  }

  case class e19(day: String = "Tue", firstSundays: Int = 0)

  // TODO - some type of recursive solution using fold left.  instead...
  def isoScrub(n: Int): String = if (n < 10) s"0$n" else s"$n"
  def makeIsoString(y: Int, m: Int, d: Int): String = s"$y-${isoScrub(m)}-${isoScrub(d)}"
  def solveJavaLocalDate: Seq[Int] = for {
    y <- 1901 to 2000
    m <- 1 to 12
    d <- 1 to daysInMonth(m,y)
    if ( d == 1 && LocalDate.parse(makeIsoString(y,m,d)).getDayOfWeek.getValue == 7)
  } yield d

  // this is the same as the For Comprehension above:
  def useMethodsInsteadOfGenerators = (1901 to 2000)
    .flatMap(y => (1 to 12)
      .flatMap(m => (1 to daysInMonth(m,y))
        .filter(d => {
          d == 1 && LocalDate.parse(makeIsoString(y,m,d)).getDayOfWeek.getValue == 7
        })
      )
    )


  def imperativeStyle:Int = {
    var today = "Tue"
    var firstSundays = 0
    for (y <- 1901 to 2000) {
      for (m <- 1 to 12) {
        for (d <- 1 to daysInMonth(m,y)) {
          if (d == 1 && today == "Sun") {
            firstSundays = firstSundays + 1
          }
          today = tomorrow(today)
        }
      }
    }
    firstSundays
  }
}
