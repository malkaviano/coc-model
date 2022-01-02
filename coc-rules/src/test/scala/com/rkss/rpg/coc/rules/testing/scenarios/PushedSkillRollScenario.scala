package com.rkss.rpg.coc.rules.testing.scenarios

import com.rkss.rpg.coc.concepts.skill.roll._

final case class PushedSkillRollScenario(
    pushedRolls: Seq[Int],
    result: SkillRolledResult,
    difficulty: Option[SkillRollDifficultyLevel],
    bonusDice: Option[BonusDice],
    penaltyDice: Option[PenaltyDice],
    chosenRoll: SkillRollDiceResult
)
