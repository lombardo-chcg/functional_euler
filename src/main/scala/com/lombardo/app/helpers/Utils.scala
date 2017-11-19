package com.lombardo.app.helpers

object Utils {
//  implicit class time[T](func: => T) {
    def time[T](msg: String)(func: T): T = {
      val t1 = System.currentTimeMillis
      val output = func
      val t2 = System.currentTimeMillis
      println(s"$msg - elapsed time ${t2 - t1} ms")
      output
    }
//  }
}
