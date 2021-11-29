package com.malk.coc.helpers

import com.malk.coc.concepts.attributes.Age
import com.malk.coc.abstractions.dices.SixSidedDice
import com.malk.coc.abstractions.dices.FourSidedDice
import com.malk.coc.abstractions.dices.TenSidedDice
import com.malk.coc.abstractions.dices.HundredSidedDice
import com.malk.coc.abstractions.dices.DiceRange

object DiceHelper {
  import scala.util.Random

  def roll8 = rollBetween(1, 9)

  def randomAge(min: Int = 15, max: Int = 89) = Age(rollBetween(min, max + 1))

  def rollRange(range: DiceRange): Int =
    rollBetween(range.min, range.max + 1)

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)

  object implicits {
    implicit val sixSidedDice = SixSidedDice(rollRange)

    implicit val fourSidedDice = FourSidedDice(rollRange)

    implicit val tenSidedDice = TenSidedDice(rollRange)

    implicit val hundredSidedDice = HundredSidedDice(rollRange)

    implicit def rangeDice(range: DiceRange): Int = rollRange(range)
  }
}
