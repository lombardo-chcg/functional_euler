package com.lombardo.app
import com.lombardo.app.helpers.Helpers._
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

  it should "compute triangle numbers" in {
    computeTriangle(285) should be(40755)
    computeTriangle(5) should be(15)
  }

  it should "compute pentagonal numbers" in {
    computePentagonal(165) should be(40755)
    computePentagonal(5) should be(35)
  }

  it should "compute hexagonal numbers" in {
    computeHexagonal(143) should be(40755)
    computeHexagonal(5) should be(45)
  }

  it should "identify pentagonal numbers" in {
    isPentagonal(4187) should be(true)
    isPentagonal(3151) should be(true)
    isPentagonal(3152) should be(false)
    isPentagonal(4185) should be(false)
    isPentagonal(40755) should be(true)
  }

  it should "identify hexagonal numbers" in {
    isHexagonal(946) should be(true)
    isHexagonal(325) should be(true)
    isHexagonal(191) should be(false)
    isHexagonal(947) should be(false)
    isHexagonal(40755) should be(true)
  }
}