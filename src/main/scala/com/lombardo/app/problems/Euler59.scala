package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers

class Euler59 {
  def encrypt(msg: Seq[Byte], key: Seq[Byte]): Seq[Byte] = {
    msg.zipWithIndex.map { case (b, idx) => (b ^ key(idx % key.size)).toByte }
  }

  // alternative to RegEx.. i.e. [[space]] \w \d
  private val allowedCharCodes = List(
    List(32),
    (48 to 57).toList,
    (65 to 90).toList,
    (97 to 122).toList
  ).flatten.map(_.toByte).zipWithIndex.toMap

  def isEnglishWordChar(p: Byte) = allowedCharCodes.contains(p)

  def solve: Int = {
    val encryptedMessage = Helpers.readFile("/p059_cipher.txt").mkString.split(",").map(_.toByte)
    val encryptionKeyCandidates: Seq[Seq[Byte]] = for {
      a <- (97 to 122)
      b <- (97 to 122)
      c <- (97 to 122)
    } yield Seq(a,b,c).map(_.toByte)

    val maxScore = 0
    val decryptedMessage = Seq.empty[Byte]

    val result = encryptionKeyCandidates.foldLeft((maxScore, decryptedMessage))((acc, key) => {
      val decryptedMessageCandidate = encrypt(encryptedMessage, key)
      val score = decryptedMessageCandidate.map(b => {
        if (isEnglishWordChar(b)) 1 else 0
      }).sum
      if (score > acc._1) {
        (score, decryptedMessageCandidate)
      } else acc
    })
    result._2.map(_.toInt).sum
  }
}
