package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.commons._

trait SkillPushable[A <: Naming] { self: SkillRollable[A] =>
  def pushRoll(
      difficulty: Option[SkillRollDifficultyLevel] = None,
      bonusDice: Option[BonusDice] = None,
      penaltyDice: Option[PenaltyDice] = None
  )(implicit hundredSidedDice: HundredSidedDice): Option[SkillRolled[A]]
}
