package com.rkss.rpg.coc.fundamentals.specs

import com.rkss.rpg.coc.concepts.internal._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.results._

final case class SkillRollSpec[A <: Naming](
    val entity: SkillRollable[A] with WithDifficultyValue with WithNaming[A],
    val difficulty: SkillRollDifficultyLevel,
    val bonusDice: BonusDice,
    val penaltyDice: PenaltyDice,
    val rolled: Seq[Int],
    val rolledResult: SkillRollResult,
    val rollDiceResult: SkillRollDiceResult
) {
  lazy val expected: SkillRolled[A] = SkillRolled(
    entity.name,
    entity.value(difficulty),
    difficulty,
    bonusDice,
    penaltyDice,
    rolledResult,
    rollDiceResult
  )
}
