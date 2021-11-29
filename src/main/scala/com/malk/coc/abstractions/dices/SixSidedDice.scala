package com.malk.coc.abstractions.dices

import com.malk.coc.traits.Dice

final case class SixSidedDice(rollD6: (DiceRange) => Int) extends Dice {
  override val name: String = "D6"

  override def roll: Int = rollD6(SixSidedDice.range)
}

object SixSidedDice {
  val range: DiceRange = DiceRange(1, 6)
}