package com.malk.coc.concepts.dices

import com.malk.coc.traits.Dice

final case class FourFacedDice(private val rollD4: ((Int, Int)) => Int) extends Dice {
  override def name: String = "D4"

  override def roll: Int = rollD4(FourFacedDice.range)
}

object FourFacedDice {
  val range: (Int, Int) = (1, 4)
}