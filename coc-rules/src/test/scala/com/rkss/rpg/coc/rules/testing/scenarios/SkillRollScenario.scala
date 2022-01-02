package com.rkss.rpg.coc.rules.testing.scenarios

import com.rkss.rpg.coc.concepts.skill.roll._

final case class SkillRollScenario(
    val regular: Int,
    val hard: Int,
    val extreme: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val skillRollResult: SkillRolledResult,
    val rolled: Seq[Int],
    val chosenRoll: SkillRollDiceResult
)
