package com.malk.coc.concepts.dices

import com.malk.coc.traits.Dice

final case class Tetrahedron(private val rollD4: ((Int, Int)) => Int) extends Dice {
  override def name: String = "D4"

  override def roll: Int = rollD4(Tetrahedron.range)
}

object Tetrahedron {
  val range: (Int, Int) = (1, 4)
}