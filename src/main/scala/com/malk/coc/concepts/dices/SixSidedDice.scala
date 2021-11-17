package com.malk.coc.concepts.dices

import com.malk.coc.traits.Dice

final case class SixSidedDice(rollD6: ((Int, Int)) => Int) extends Dice {
  override val name: String = "D6"

  override def roll: Int = rollD6(SixSidedDice.range)
}

object SixSidedDice {
  val range: (Int, Int) = (1, 6)
}