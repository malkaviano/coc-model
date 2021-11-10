package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Strength, Size}
import com.malk.coc.helpers.Dice._
import com.malk.coc.concepts.traits.Attribute

case class DamageBonus(
  private val str: Strength,
  private val siz: Size
) extends Attribute {
  override val name = "Damage Bonus"

  override def value: Int = str.value + siz.value match {
    case x if x < 65 => -2
    case x if x < 85 => -1
    case x if x < 125 => 0
    case x if x < 165 => roll4
    case x if x < 205 => roll6
    case x if x < 285 => 1 to 2 map { _ => roll6 } reduce { _ + _ }
    case x if x < 365 => 1 to 3 map { _ => roll6 } reduce { _ + _ }
    case x if x < 445 => 1 to 4 map { _ => roll6 } reduce { _ + _ }
    case x if x < 525 => 1 to 5 map { _ => roll6 } reduce { _ + _ }
    case x =>
      val y = x - 524
      val dices = (y / 80.0).ceil.toInt + 5
      1 to dices map { _ => roll6 } reduce { _ + _ }
  }
}