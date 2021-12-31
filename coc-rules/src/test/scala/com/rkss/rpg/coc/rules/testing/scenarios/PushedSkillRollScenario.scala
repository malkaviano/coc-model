package com.rkss.rpg.coc.testing.scenarios

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.traits.DiceResult

final case class PushedSkillRollScenario(
    pushedRolls: Seq[Int],
    result: SkillRolledResult,
    difficulty: Option[SkillRollDifficultyLevel],
    bonusDice: Option[BonusDice],
    penaltyDice: Option[PenaltyDice],
    chosenRoll: DiceResult
)
