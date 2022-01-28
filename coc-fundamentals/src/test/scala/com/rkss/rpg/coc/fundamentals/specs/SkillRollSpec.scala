package com.rkss.rpg.coc.fundamentals.specs

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class SkillRollSpec(
    val entity: SkillRollable with EntityWithDifficultyValue with EntityWithNameTag,
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val rolled: Seq[Int],
    val rolledResult: SkillRolledResult,
    val rollDiceResult: SkillRollDiceResult
) {
  lazy val expected: SkillRolled = SkillRolled(
    entity.name,
    entity.value(difficulty),
    difficulty,
    bonusDice,
    penaltyDice,
    rolledResult,
    rollDiceResult
  )
}
