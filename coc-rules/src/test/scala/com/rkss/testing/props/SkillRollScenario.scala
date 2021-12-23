package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.skillroll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skillroll.BonusDice
import com.rkss.rpg.coc.concepts.skillroll.PenaltyDice
import com.rkss.rpg.coc.concepts.skillroll.SkillRollResult

final case class SkillRollScenario(
    val rollableValue: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val skillRollResult: SkillRollResult,
    val rolled: Seq[Int]
)
