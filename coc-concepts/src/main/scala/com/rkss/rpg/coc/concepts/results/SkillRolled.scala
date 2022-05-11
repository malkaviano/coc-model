package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.coc.concepts.internal._
import com.rkss.rpg.coc.concepts.roll._

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
