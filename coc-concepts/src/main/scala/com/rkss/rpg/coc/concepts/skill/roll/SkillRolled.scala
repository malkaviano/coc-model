package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.coc.concepts._

final case class SkillRolled[A <: NameTag](
    val name: A,
    val value: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val result: SkillRollResult,
    val rolled: SkillRollDiceResult,
    val pushed: Boolean = false
)
