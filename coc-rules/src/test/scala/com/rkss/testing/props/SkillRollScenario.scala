package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.roll.BonusDice
import com.rkss.rpg.coc.concepts.roll.PenaltyDice
import com.rkss.rpg.coc.concepts.roll.SkillRollResult

final case class SkillRollScenario(
    val rollableValue: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val skillRollResult: SkillRollResult,
    val rolled: Seq[Int]
)
