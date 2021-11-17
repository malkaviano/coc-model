package com.malk.coc.helpers

import com.malk.coc.concepts.attributes.Age
import com.malk.coc.concepts.dices.SixSidedDice
import com.malk.coc.concepts.dices.FourSidedDice
import com.malk.coc.concepts.dices.TenSidedDice
import com.malk.coc.concepts.dices.HundredSidedDice

object DiceHelper {
  import scala.util.Random

  def roll8 = rollBetween(1, 9)

  def randomAge(min: Int = 15, max: Int = 89) = Age(rollBetween(min, max + 1))

  def rollRange(range: (Int, Int)): Int =
    rollBetween(range._1, range._2 + 1)

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)

  object implicits {
    implicit val sixSidedDice = SixSidedDice(rollRange)

    implicit val fourSidedDice = FourSidedDice(rollRange)

    implicit val tenSidedDice = TenSidedDice(rollRange)

    implicit val hundredSidedDice = HundredSidedDice(rollRange)
  }
}
