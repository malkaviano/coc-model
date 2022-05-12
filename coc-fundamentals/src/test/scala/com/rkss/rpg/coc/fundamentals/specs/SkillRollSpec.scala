package com.rkss.rpg.coc.fundamentals.specs

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.fundamentals._

final case class SkillRollSpec[A <: SkillRollNaming](
    val entity: BaseRollable[A],
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
