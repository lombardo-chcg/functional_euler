package com.lombardo.app.problems

import java.time.LocalDate

class Euler19 {
  def getDaysInMonth(m: Int, y: Int): Int = {
    m match {
      case 1 | 3 | 5 | 7 | 8 | 10 | 12 => 31
      case 4 | 6 | 9 | 11 => 30
      case 2 => handleFeb(y)
    }
  }

  def tomorrowAsValue(today: Int): Int = {
    if (today == 7) 1 else today + 1
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

  //  Solve using Java 8 Date stuff
  //  SOURCES
  //  LocalDate.parse param: A String representing a date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03 - need ISO scrub method
  //  #getDayOfWeek.getValue: https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html#SUNDAY
  def isSunday(y:Int, m:Int, d: Int): Boolean = LocalDate.parse(makeIsoString(y,m,d)).getDayOfWeek.getValue == 7
  def isoScrub(n: Int): String = if (n < 10) s"0$n" else s"$n"
  def makeIsoString(y: Int, m: Int, d: Int): String = s"$y-${isoScrub(m)}-${isoScrub(d)}"

  // TODO - some type of recursive solution using fold left.  instead...
  def solveJavaLocalDate: Seq[Int] = for {
    y <- 1901 to 2000
    m <- 1 to 12
    d <- 1 to getDaysInMonth(m,y)
    if ( d == 1 && isSunday(y,m,d))
  } yield d

  // this is the same as the For Comprehension above:
  def useMethodsInsteadOfGenerators = (1901 to 2000)
    .flatMap(y => (1 to 12)
      .flatMap(m => (1 to getDaysInMonth(m,y))
        .filter(d => d == 1 && isSunday(y,m,d))
      )
    )

  def imperativeStyle:Int = {
    var today = 2
    var firstSundays = 0
    for (y <- 1901 to 2000) {
      for (m <- 1 to 12) {
        for (d <- 1 to getDaysInMonth(m,y)) {
          if (d == 1 && today == 7) {
            firstSundays = firstSundays + 1
          }
          today = tomorrowAsValue(today)
        }
      }
    }
    firstSundays
  }
}
