package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skillroll._

final case class SkillRoll(
    val rollable: SkillRollable,
    val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    val bonusDice: BonusDice = BonusDice(0),
    val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRollResult = roll

  private def roll: SkillRollResult = SkillRollResolver.instance.roll(
    rollable,
    difficulty,
    bonusDice,
    penaltyDice
  )
}
