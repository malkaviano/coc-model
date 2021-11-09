package com.malk.coc.helpers

import com.malk.coc.concepts.characteristics.Age

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

  def randomAge = Age(rollBetween(15, 90))

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)
}