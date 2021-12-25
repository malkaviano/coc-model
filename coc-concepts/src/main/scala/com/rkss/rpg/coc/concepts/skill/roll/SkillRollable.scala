package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.dice.HundredSidedDice

trait SkillRollable {
  def value(difficulty: SkillRollDifficultyLevel): Int

  def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled
}
