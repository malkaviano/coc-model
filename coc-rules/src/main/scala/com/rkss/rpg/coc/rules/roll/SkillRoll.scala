package com.rkss.rpg.coc.rules.roll

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.helpers.traits.DiceResult

final case class SkillRoll(
    private val rollable: Rollable,
    private val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    private val bonusDice: BonusDice = BonusDice(0),
    private val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRollResult = {
    val regular = rollable.value(difficulty)
    val hard = regular / 2
    val extreme = regular / 5

    val fumble = if (regular < 50) 96 else 100

    val rolled = rollDice.value

    rolled match {
      case 1                                   => CriticalSuccess
      case diceResult if diceResult >= fumble  => Fumble
      case diceResult if diceResult <= extreme => ExtremeSuccess
      case diceResult if diceResult <= hard    => HardSuccess
      case diceResult if diceResult <= regular => RegularSuccess
      case _                                   => Failure
    }
  }

  private def rollDice: DiceResult = {
    hundredSidedDice.roll
  }
}
