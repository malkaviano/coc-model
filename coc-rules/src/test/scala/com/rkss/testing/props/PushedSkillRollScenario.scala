package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.skillroll._

final case class PushedSkillRollScenario(
    rollable: SkillRollable,
    failedRolls: Seq[Int],
    pushedRolls: Seq[Int],
    result: SkillRollResult,
    difficulty: Option[SkillRollDifficultyLevel],
    bonusDice: Option[BonusDice],
    penaltyDice: Option[PenaltyDice]
)
