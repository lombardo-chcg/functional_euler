package com.lombardo.app.problems

import com.lombardo.app.helpers.Helpers

import scala.annotation.tailrec
import scala.util.Try

object CardValues {
  def apply(cardValue: String): Int = cardValue.toLowerCase match {
    case "t" => 10
    case "j" => 11
    case "q" => 12
    case "k" => 13
    case "a" => 14
    case other => Try(other.toInt).getOrElse(throw new IllegalArgumentException("Illegal card value: " + cardValue))
  }
}

object Suits extends Enumeration {
  val Hearts, Diamonds, Clubs, Spades = Value
  def apply(letter: String): Suits.Value = {
    letter.toLowerCase match {
      case "h" => Hearts
      case "d" => Diamonds
      case "c" => Clubs
      case "s" => Spades
      case _ => throw new IllegalArgumentException("no suit type for " + letter)
    }
  }
}

case class Card(value: Int, suit: Suits.Value)

case object Card {
  def apply(s: String): Card = {
    if (s.size != 2) throw new IllegalArgumentException("Illegal card input: " + s + ". Usage: AH, TD, 5S")
    val value = s.split("")(0)
    val suit = s.split("")(1)
    Card(CardValues(value), Suits(suit))
  }
}

sealed trait GameResult
case object Player1 extends GameResult
case object Player2 extends GameResult

case class Score(value: Int, tiebreaker: Int)

object PokerRules {
  def determineWinner(a: Hand, b: Hand): GameResult = {
    val as = extractScore(a)
    val bs = extractScore(b)
    if (as.value != bs.value) {
      if (as.value > bs.value) Player1 else Player2
    } else if (as.tiebreaker != bs.tiebreaker) {
      if (as.tiebreaker > bs.tiebreaker) Player1 else Player2
    } else recExtract(a,b)
  }

  @tailrec
  def recExtract(a: Hand, b: Hand): GameResult = {
    if (a.cards.size == 0 && b.cards.size == 0) throw new Exception(s"Tie Game! Illegal state!  Per instructions: 'in each hand there is a clear winner'")
    else if (a.highestCard.value == b.highestCard.value) recExtract(a.drop(List(a.highestCard)), b.drop(List(b.highestCard)))
    else {
      if (a.highestCard.value > b.highestCard.value) Player1 else Player2
    }
  }

  def extractScore(h: Hand): Score = {
    if (h.royalFlush.nonEmpty)                        Score(10, 14)
    else if (h.straightFlush.nonEmpty)                Score(9, h.highestCard.value)
    else if (h.fourOfAKind.nonEmpty)                  Score(8, h.fourOfAKind.get.keys.max)
    else if (h.fullHouse.nonEmpty)                    Score(7, h.threeOfAKind.get.keys.max)
    else if (h.flush.nonEmpty)                        Score(6, h.highestCard.value)
    else if (h.straight.nonEmpty)                     Score(5, h.highestCard.value)
    else if (h.threeOfAKind.nonEmpty)                 Score(4, h.threeOfAKind.get.keys.max)
    else if (h.pairs.exists(p => p.values.size > 1))  Score(3, h.pairs.get.keys.sum)
    else if (h.pairs.nonEmpty)                        Score(2, h.pairs.get.keys.max)
    else                                              Score(1, h.highestCard.value)
  }
}

case class Hand(cards: List[Card]) {
  def opt(arg: Map[Int, List[Card]]) = if (arg.values.size > 0) Some(arg) else None
  def drop(cardsToDrop: List[Card]): Hand = Hand(cards.filterNot(cardsToDrop.contains(_)))

  def highestCard: Card = cards.sortBy(_.value).last
  def pairs: Option[Map[Int, List[Card]]] = opt(cards.groupBy(_.value).filter(_._2.size == 2))
  def threeOfAKind: Option[Map[Int, List[Card]]] = opt(cards.groupBy(_.value).filter(_._2.size == 3))
  def straight: Option[Hand] = {
    val cardValueSet = cards.map(_.value).toSet
    val max = cardValueSet.max
    val min = cardValueSet.min
    val isStraight = {
      // ace case
      if (max == 14) {
        (min to min+4).toSet.subsetOf(cardValueSet) || cardValueSet.subsetOf(Set(14,2,3,4,5))
      }
      else (min to min+4).toSet.subsetOf(cardValueSet)
    }
    if (isStraight) Some(this) else None
  }
  def flush: Option[Suits.Value] = cards.groupBy(_.suit).filter(_._2.size == 5).keys.headOption
  def fullHouse: Option[Hand] = {
    if (threeOfAKind.nonEmpty && {
      this.drop(threeOfAKind.get.values.toList.flatten).pairs.nonEmpty
    }) Some(this) else None
  }
  def fourOfAKind: Option[Map[Int, List[Card]]] = opt(cards.groupBy(_.value).filter(_._2.size == 4))
  def straightFlush: Option[Hand] = if (straight.nonEmpty && flush.nonEmpty) Some(this) else None
  def royalFlush: Option[Hand] = if (straightFlush.nonEmpty && highestCard.value == 14) Some(this) else None
}

case object Hand {
  def apply(s: String): Hand = {
    Hand(s.split(" ").map(Card(_)).toList)
  }
}

class Euler54 {
  def solve:Int = {
    Helpers.readFile("/p054_poker.txt").toList.count(cards => {
      val h1 = Hand(cards.split(" ").take(5).mkString(" "))
      val h2 = Hand(cards.split(" ").takeRight(5).mkString(" "))
      PokerRules.determineWinner(h1, h2) == Player1
    })
  }
}
