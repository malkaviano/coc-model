package com.malk.coc.concepts.dices

import com.malk.coc.traits.Dice

final case class DeltohedronDice(rollD10: ((Int, Int)) => Int) extends Dice {
  override val name: String = "D10"

  override def roll: Int = rollD10(DeltohedronDice.range)
}

object DeltohedronDice {
  val range: (Int, Int) = (1, 10)
}