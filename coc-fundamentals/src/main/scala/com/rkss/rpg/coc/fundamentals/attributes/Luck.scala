package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.helpers.dice._

final case class Luck(override val baseValue: Int)
    extends EntityWithBaseValue
    with EntityWithBasicRoll[LuckRolled] {
  override def roll(implicit
      hundredSidedDice: HundredSidedDice
  ): LuckRolled = {
    val rollDiceResult = RollDiceResult(hundredSidedDice.roll.value)

    val rollResult = rollDiceResult match {
      case RollDiceResult(x) if x <= baseValue => SuccessRoll
      case _                                   => FailureRoll
    }

    LuckRolled(baseValue, rollDiceResult, rollResult)
  }
}
