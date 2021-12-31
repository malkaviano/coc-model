package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.dice.HundredSidedDice

private[coc] trait SkillRollable {
  def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled
}
