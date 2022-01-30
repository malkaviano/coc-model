package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.coc.concepts._

final case class SkillRolled(
    val name: NameTag,
    val value: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val rollResult: SkillRollResult,
    val rolled: SkillRollDiceResult,
    val pushed: Boolean = false
)
