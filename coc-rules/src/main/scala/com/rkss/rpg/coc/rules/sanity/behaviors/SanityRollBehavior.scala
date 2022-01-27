package com.rkss.rpg.coc.rules.sanity.behaviors

import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.RollDiceResult

private[coc] trait SanityRollBehavior { self: Sanity =>
  override def roll(implicit
      hundredSidedDice: HundredSidedDice
  ): SanityRolled = {
    val rolled = hundredSidedDice.roll.value

    val fumble = if (this.current < 50) 96 else 100

    val result = rolled match {
      case diceResult if diceResult >= fumble       => Fumble
      case diceResult if diceResult <= this.current => SuccessResult
      case _                                        => FailureResult
    }

    SanityRolled(
      this.current,
      this.maximum,
      result,
      RollDiceResult(rolled)
    )
  }
}
