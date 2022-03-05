package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.results._

final case class SkillRolled[+A <: Naming](
    val name: A,
    val value: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val result: SkillRollResult,
    val rolled: SkillRollDiceResult,
    val pushed: Boolean = false
)
