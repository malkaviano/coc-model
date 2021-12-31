package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue

final case class SkillRolled(
    val rollable: EntityWithDifficultyValue,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val rollResult: SkillRolledResult,
    val rolled: DiceResult,
    val pushed: Boolean = false
)
