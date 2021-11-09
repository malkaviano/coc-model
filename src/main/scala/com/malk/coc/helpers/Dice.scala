package com.malk.coc.helpers

object Dice {
  import scala.util.Random

  def roll10 = rollBetween(1, 11)

  def roll8 = rollBetween(1, 9)

  def roll6 = rollBetween(1, 7)

  def roll4 = rollBetween(1, 5)

  def roll100 = (roll10 * 10) + roll10 match {
    case x if x > 100 => x - 100
    case x => x
  }

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)
}