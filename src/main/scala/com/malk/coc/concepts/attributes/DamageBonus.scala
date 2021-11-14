package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Strength, Size}
import com.malk.coc.traits.Attribute
import com.malk.coc.concepts.dices.CubeDice
import com.malk.coc.concepts.dices.TetrahedronDice

final case class DamageBonus(
    private val str: Strength,
    private val siz: Size
)(implicit
    private val tetrahedronDice: TetrahedronDice,
    private val cubeDice: CubeDice
) extends Attribute {
  override val name = "Damage Bonus"

  override val value: Int = str.value + siz.value match {
    case x if x < 65  => -2
    case x if x < 85  => -1
    case x if x < 125 => 0
    case x if x < 165 => tetrahedronDice.roll
    case x if x < 205 => cubeDice.roll
    case x if x < 285 => 1 to 2 map { _ => cubeDice.roll } reduce { _ + _ }
    case x if x < 365 => 1 to 3 map { _ => cubeDice.roll } reduce { _ + _ }
    case x if x < 445 => 1 to 4 map { _ => cubeDice.roll } reduce { _ + _ }
    case x if x < 525 => 1 to 5 map { _ => cubeDice.roll } reduce { _ + _ }
    case x =>
      val y = x - 524
      val dices = (y / 80.0).ceil.toInt + 5
      1 to dices map { _ => cubeDice.roll } reduce { _ + _ }
  }
}
