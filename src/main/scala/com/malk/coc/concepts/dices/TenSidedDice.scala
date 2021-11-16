package com.malk.coc.concepts.dices

import com.malk.coc.traits.Dice

final case class TenSidedDice(rollD10: ((Int, Int)) => Int) extends Dice {
  override val name: String = "D10"

  override def roll: Int = rollD10(TenSidedDice.range)
}

object TenSidedDice {
  val range: (Int, Int) = (1, 10)
}