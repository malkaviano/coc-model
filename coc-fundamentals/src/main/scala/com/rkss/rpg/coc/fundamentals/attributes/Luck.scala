package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.attributes._

final case class Luck(override val baseValue: Int)
    extends EntityWithBaseValue
    with EntityWithBasicRoll[LuckRolled] {
  override def roll(implicit
      hundredSidedDice: HundredSidedDice
  ): LuckRolled = {
    val rollDiceResult = DiceRolled(hundredSidedDice.roll.value)

    val rollResult = rollDiceResult match {
      case DiceRolled(x) if x <= baseValue => SuccessRoll
      case _                                   => FailureRoll
    }

    LuckRolled(baseValue, rollDiceResult, rollResult)
  }
}
