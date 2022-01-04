package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.dice.HundredSidedDice

trait SkillPushable { self: SkillRollable =>
  def pushRoll(
      difficulty: Option[SkillRollDifficultyLevel] = None,
      bonusDice: Option[BonusDice] = None,
      penaltyDice: Option[PenaltyDice] = None
  )(implicit hundredSidedDice: HundredSidedDice): Option[SkillRolled]
}
