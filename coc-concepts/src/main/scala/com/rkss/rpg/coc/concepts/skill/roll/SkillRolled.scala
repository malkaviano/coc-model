package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.traits.DiceResult

final case class SkillRolled(
    val rollable: SkillRollable,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val rollResult: SkillRollResult,
    val rolled: DiceResult,
    val pushed: Boolean = false
)
