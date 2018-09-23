package com.lombardo.app

import com.lombardo.app.helpers.Utils.time
import com.lombardo.app.problems._

class Euler54Test extends EulerTestBase {
  import Suits._
  val e = new Euler54

  val `5 of Hearts` = Card(5, Hearts)
  val `King of Diamonds` = Card(13, Diamonds)
  val `Ace of Clubs` = Card(14, Clubs)
  val hand1 = Hand(List(`5 of Hearts`, `King of Diamonds`, `Ace of Clubs`))

  it should "have good helpers" in {
    Card("5H") should be(`5 of Hearts`)
    Card("KD") should be(`King of Diamonds`)
    Card("AC") should be(`Ace of Clubs`)
    hand1.highestCard should be(`Ace of Clubs`)
    Hand("5H 5C 6S 7S KD").pairs.get should be(Map(5 -> List(Card("5H"), Card("5C"))))
    Hand("2C 3S 8S 8D TD").pairs.get should be(Map(8 -> List(Card("8S"), Card("8D"))))
    Hand("5D 8C 9S JS AC").highestCard should be(Card("AC"))
    Hand("2C 5C 7D 8S QH").highestCard should be(Card("QH"))
    Hand("2D 9C AS AH AC").threeOfAKind.get should be(Map(14 -> List(Card("AS"), Card("AH"), Card("AC"))))
    Hand("2D 9C AS AH AC").flush should be(None)
    Hand("3D 6D 7D TD QD").flush.get should be(Diamonds)
    Hand("4D 6S 9H QH QC").pairs.get should be(Map(12 -> List(Card("QH"),Card("QC"))))
    Hand("4D 6S 9H QH QC").drop(List(Card("QH"),Card("QC"))) should be(Hand("4D 6S 9H"))
    Hand("4D 6S 9H QH QC").drop(List(Card("QH"),Card("QC"))).highestCard should be(Card("9H"))
    Hand("3D 6D 7H QD QS").pairs.get should be(Map(12 -> List(Card("QD"), Card("QS"))))
    Hand("2H 2D 4C 4D 4S").fullHouse.get should be(Hand("2H 2D 4C 4D 4S"))
    Hand("3D 6D 7H QD QS").fullHouse should be(None)
    Hand("3C 3D 3S 9S 9D").fullHouse.get should be(Hand("3C 3D 3S 9S 9D"))
    Hand("3C 3D 3S 9S 9D").threeOfAKind.get should be(Map(3 -> List(Card("3c"), Card("3d"), Card("3s"))))
    Hand("3C 4D 5S 6S 7D").straight.nonEmpty should be(true)
    Hand("2H AC 4D 3D 5D").straight.nonEmpty should be(true)
    Hand("3D 6D 7H QD QS").straight should be(None)
    Hand("3C 3D 3S 9S 3H").fourOfAKind.get should be(Map(3 -> List(Card("3c"), Card("3d"), Card("3s"), Card("3h"))))
    Hand("3C 4c 5c 6c 7c").straightFlush.nonEmpty should be(true)
    Hand("aC kc qc jc tc").royalFlush.nonEmpty should be(true)

    PokerRules.determineWinner(Hand("5H 5C 6S 7S KD"), Hand("2C 3S 8S 8D TD")) should be(Player2)
    PokerRules.determineWinner(Hand("5D 8C 9S JS AC"), Hand("2C 5C 7D 8S QH")) should be(Player1)
    PokerRules.determineWinner(Hand("2D 9C AS AH AC"), Hand("3D 6D 7D TD QD")) should be(Player2)
    PokerRules.determineWinner(Hand("4D 6S 9H QH QC"), Hand("3D 6D 7H QD QS")) should be(Player1)
    PokerRules.determineWinner(Hand("2H 2D 4C 4D 4S"), Hand("3C 3D 3S 9S 9D")) should be(Player1)
  }

  it should "solve" in {
    time(s"${getClass.getSimpleName.replace("Test", "")}") {
      e.solve should be(376)
    }
  }
}