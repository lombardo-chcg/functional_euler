package com.lombardo.app
import com.lombardo.app.objs.Helpers._
import org.scalatest.{FlatSpec, Matchers}

class HelpersTest extends FlatSpec with Matchers {
  it should "know about palindromes" in {
    isPalindrome("585") should equal(true)
    isPalindrome("no") should equal(false)
    isPalindrome("1001001001") should equal(true)
    isPalindrome("antidisestablishmentarianism") should equal(false)
    isPalindrome("estimation") should equal(false)
    isPalindrome("tattarrattat") should equal(true)
    isPalindrome("999989") should equal(false)
  }
}