package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.Skill

private[coc] trait SkillRollOpposable { self: Skill =>
  def rollOpposedBy(
      opposedBy: EntityWithDifficultyValue,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled
}
