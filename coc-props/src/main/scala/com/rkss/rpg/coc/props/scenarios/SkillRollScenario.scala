package com.rkss.rpg.coc.props.scenarios

import com.rkss.rpg.coc.concepts.skill.roll._

final case class SkillRollScenario(
    val rollableValue: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val skillRollResult: SkillRollResult,
    val rolled: Seq[Int]
)
