package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.dice._

final case class DamageBonus(
    private val strength: Characteristic[Strength.type],
    private val size: Characteristic[Size.type]
)(implicit
    private val fourSidedDice: FourSidedDice,
    private val sixSidedDice: SixSidedDice
) extends AttributeWithCurrentValue {
  override def current: Int = {
    strength.value() + size.value() match {
      case x if x < 65  => -2
      case x if x < 85  => -1
      case x if x < 125 => 0
      case x if x < 165 => fourSidedDice.roll.value
      case x if x < 205 => sixSidedDice.roll.value
      case x if x < 285 =>
        1 to 2 map { _ => sixSidedDice.roll.value } reduce { _ + _ }
      case x if x < 365 =>
        1 to 3 map { _ => sixSidedDice.roll.value } reduce { _ + _ }
      case x if x < 445 =>
        1 to 4 map { _ => sixSidedDice.roll.value } reduce { _ + _ }
      case x if x < 525 =>
        1 to 5 map { _ => sixSidedDice.roll.value } reduce { _ + _ }
      case x =>
        val y = x - 524
        val dices = (y / 80.0).ceil.toInt + 5
        1 to dices map { _ => sixSidedDice.roll.value } reduce { _ + _ }
    }
  }
}
