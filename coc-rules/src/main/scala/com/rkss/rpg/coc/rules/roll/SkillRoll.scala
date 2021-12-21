package com.rkss.rpg.coc.rules.roll

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.roll._

final case class SkillRoll(
    private val rollable: Rollable,
    private val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    private val bonusDice: BonusDice = BonusDice(0),
    private val penalty: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRollResult = {
    val value = rollable.value(difficulty)
    val rolled = hundredSidedDice.roll.value

    rolled match {
      case 1 => CriticalSuccess
      case 100 => Fumble
      case diceResult if diceResult <= value => RegularSuccess
      case _ => Failure
    }
  }
}
