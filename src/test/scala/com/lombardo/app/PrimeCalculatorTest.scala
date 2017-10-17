package com.lombardo.app
import com.lombardo.app.helpers.PrimeCalculator
import com.lombardo.app.helpers.Utils._
import org.scalatest.{FlatSpec, Matchers}

class PrimeCalculatorTest extends FlatSpec with Matchers {
  val pc = new PrimeCalculator

  it should "return a list of all primes under a given number" in {
    val expected30 = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val expected100 = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    val expected1000 = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997)
    pc.primesUnder(1) should equal(List())
    pc.primesUnder(2) should equal(List())
    pc.primesUnder(3) should equal(List(2))
    pc.primesUnder(4) should equal(List(2, 3))
    pc.primesUnder(30) should equal(expected30)
    pc.primesUnder(100) should equal(expected100)
    pc.primesUnder(1000) should equal(expected1000)
  }

  it should "tell if a number is prime or not" in {
    pc.isPrime(2) should equal(true)
    pc.isPrime(3) should equal(true)
    pc.isPrime(4) should equal(false)
    pc.isPrime(1487) should equal(true)
    pc.isPrime(4817) should equal(true)
    pc.isPrime(8147) should equal(true)
    pc.isPrime(105727) should equal(true)
    pc.isPrime(1301081) should equal(true)
    pc.isPrime(1301082) should equal(false)
    pc.isPrime(2342357) should equal(true)
  }

  it should "return the nth prime number" in {
    pc.nthPrime(10) should equal(29)
    pc.nthPrime(10001) should equal(104743)
    time("nth prime (n = 1000000)"){
      pc.nthPrime(1000000) should equal(15485863)
    }
  }

  it should "offer a prime lookup map from int to bool" in {
    val map = pc.primeMap(pc.primesUnder(100))
    map.contains(29) should be(true)
    map.contains(80) should be(false)
    map.get(67) should be(Some(true))
    map.get(78) should be(None)
  }

  it should "find prime factors" in {
    val primeList = pc.primesUnder(1000)
    pc.primeFactors(6, primeList) should be(List(2, 3))
    pc.primeFactors(8, primeList) should be(List(2, 2, 2))
    pc.primeFactors(14, primeList) should be(List(2, 7))
    pc.primeFactors(15, primeList) should be(List(3, 5))
    pc.primeFactors(644, primeList) should be(List(2,2,7,23))
    pc.primeFactors(645, primeList) should be(List(3, 5, 43))
    pc.primeFactors(646, primeList) should be(List(2,17,19))
  }
}
