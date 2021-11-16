package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.concepts.dices.SixSidedDice
import com.malk.coc.concepts.dices.FourSidedDice
import com.malk.coc.concepts.abstractions.Body

final case class DamageBonus(
    private val body: Body
)(implicit
    private val fourSidedDice: FourSidedDice,
    private val sixSidedDice: SixSidedDice
) extends Attribute("Damage Bonus", 0) {

  override val value: Int = body.strength.value + body.size.value match {
    case x if x < 65  => -2
    case x if x < 85  => -1
    case x if x < 125 => 0
    case x if x < 165 => fourSidedDice.roll
    case x if x < 205 => sixSidedDice.roll
    case x if x < 285 => 1 to 2 map { _ => sixSidedDice.roll } reduce { _ + _ }
    case x if x < 365 => 1 to 3 map { _ => sixSidedDice.roll } reduce { _ + _ }
    case x if x < 445 => 1 to 4 map { _ => sixSidedDice.roll } reduce { _ + _ }
    case x if x < 525 => 1 to 5 map { _ => sixSidedDice.roll } reduce { _ + _ }
    case x =>
      val y = x - 524
      val dices = (y / 80.0).ceil.toInt + 5
      1 to dices map { _ => sixSidedDice.roll } reduce { _ + _ }
  }
}
