package com.rkss.rpg.coc.props.scenarios

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.traits.DiceResult

final case class SkillRollScenario(
    val regular: Int,
    val hard: Int,
    val extreme: Int,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val skillRollResult: SkillRollResult,
    val rolled: Seq[Int],
    val chosenRoll: DiceResult
)
