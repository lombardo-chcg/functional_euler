package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers

class Euler59 {

  def encrypt(n: Int, key: Int): Int = n ^ key

  def loop = {
    for {
     a <-  (97 to 122)
    } yield 
  }
  
  def solve:Int = {
    val encryptedAsciiCodes = Helpers.readFile("/p059_cipher.txt").mkString.split(",").map(_.toInt.toChar)
    val msgLen = encryptedAsciiCodes.size
    val encryptionKeyCandidates = (97 to 122).map(_.toChar).combinations(3).toList
    val x = encryptionKeyCandidates.flatMap(key => {
      val cyclicKey = (1 to 866).map(_ => key) :+ key.dropRight(1)
      val res = encryptedAsciiCodes.map(x => (x.toInt ^ cyclicKey.map(keyset => keyset.map(_.toInt).sum).sum)).filter(p => p >= 32 && p <= 126).map(_.toChar).mkString
      if (res.size == msgLen) Some(res) else None
    })
    x.foreach(println)
    println(x.size)
    println(encryptionKeyCandidates.size)
    15
  }
}
