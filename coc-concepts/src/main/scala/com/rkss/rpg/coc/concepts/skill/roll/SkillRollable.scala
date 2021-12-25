package com.rkss.rpg.coc.concepts.skill.roll

trait SkillRollable {
  def value(difficulty: SkillRollDifficultyLevel): Int

  def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  ): SkillRollResult
}
