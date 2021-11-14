package com.malk.coc.helpers

import com.malk.coc.concepts.characteristics.Age

object DiceHelper {
  import scala.util.Random

  def roll10 = rollBetween(1, 11)

  def roll8 = rollBetween(1, 9)

  def roll6 = rollBetween(1, 7)

  def roll4 = rollBetween(1, 5)

  def roll100 = rollBetween(1, 101)

  def randomAge(min: Int = 15, max: Int = 89) = Age(rollBetween(min, max + 1))

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)
}