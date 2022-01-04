package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.helpers.dice.HundredSidedDice

trait WithBasicRollBehavior {
  self: EntityWithBasicRoll =>

  override def roll(implicit
      hundredSidedDice: HundredSidedDice
  ): EntityRolled = {
    val rollDiceResult = RollDiceResult(hundredSidedDice.roll.value)

    val rollResult = rollDiceResult match {
      case RollDiceResult(x) if x <= baseValue => SuccessRoll
      case _                                   => FailureRoll
    }

    EntityRolled(this, rollDiceResult, rollResult)
  }
}
