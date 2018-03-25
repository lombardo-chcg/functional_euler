package com.lombardo.app
import com.lombardo.app.helpers.Helpers._

class HelpersTest extends EulerTestBase {
  "helpers" should "know about palindromes" in {
    isPalindrome("585") should be(true)
    isPalindrome("no") should be(false)
    isPalindrome("1001001001") should be(true)
    isPalindrome("antidisestablishmentarianism") should be(false)
    isPalindrome("estimation") should be(false)
    isPalindrome("tattarrattat") should be(true)
    isPalindrome("999989") should be(false)
    isPalindrome(121) should be(true)
    isPalindrome(BigInt("4668731596684224866951378664")) should be(true)
  }

  it should "compute triangle numbers" in {
    computeTriangle(285) should be(40755)
    computeTriangle(5) should be(15)
  }

  it should "compute pentagonal numbers" in {
    computePentagonal(165) should be(40755)
    computePentagonal(5) should be(35)
    (1L to 10L).map(computePentagonal) should be(List(1, 5, 12, 22, 35, 51, 70, 92, 117, 145))
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