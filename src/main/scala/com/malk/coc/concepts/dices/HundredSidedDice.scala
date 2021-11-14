package com.malk.coc.concepts.dices

import com.malk.coc.traits.Dice

final case class HundredSidedDice(rollD100: ((Int, Int)) => Int) extends Dice {
  override val name: String = "D100"

  override def roll: Int = rollD100(HundredSidedDice.range)
}

object HundredSidedDice {
  val range: (Int, Int) = (1, 100)
}