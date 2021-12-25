package com.rkss.rpg.coc.props.scenarios

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.traits.DiceResult

final case class PushedSkillRollScenario(
    rollable: SkillRollable,
    failedRolls: Seq[Int],
    pushedRolls: Seq[Int],
    result: SkillRollResult,
    difficulty: Option[SkillRollDifficultyLevel],
    bonusDice: Option[BonusDice],
    penaltyDice: Option[PenaltyDice],
    chosenRoll: DiceResult
)
