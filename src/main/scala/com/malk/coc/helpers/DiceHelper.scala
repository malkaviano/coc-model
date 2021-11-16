package com.malk.coc.helpers

import com.malk.coc.concepts.attributes.Age
import com.malk.coc.concepts.dices.SixFacedDice
import com.malk.coc.concepts.dices.FourFacedDice
import com.malk.coc.concepts.dices.TenFacedDice
import com.malk.coc.concepts.dices.HundredSidedDice

object DiceHelper {
  import scala.util.Random

  def roll8 = rollBetween(1, 9)

  def randomAge(min: Int = 15, max: Int = 89) = Age(rollBetween(min, max + 1))

  def rollRange(range: (Int, Int)): Int =
    rollBetween(range._1, range._2 + 1)

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)

  object implicits {
    implicit val sixFacedDice = SixFacedDice(rollRange)

    implicit val fourFacedDice = FourFacedDice(rollRange)

    implicit val tenFacedDice = TenFacedDice(rollRange)

    implicit val hundredSidedDice = HundredSidedDice(rollRange)
  }
}
