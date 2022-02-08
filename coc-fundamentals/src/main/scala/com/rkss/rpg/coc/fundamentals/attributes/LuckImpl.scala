package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.attributes.luck._

final case class LuckImpl(override val baseValue: Int)
    extends Luck {
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
