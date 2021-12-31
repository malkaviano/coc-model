package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.concepts.RollableEntity

final case class SkillRolled(
    val rollable: RollableEntity,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val rollResult: SkillRollResult,
    val rolled: DiceResult,
    val pushed: Boolean = false
)
