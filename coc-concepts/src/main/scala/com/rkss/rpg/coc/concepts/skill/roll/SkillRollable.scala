package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.NameTag

trait SkillRollable[A <: NameTag] { self: EntityWithDifficultyValue =>
  def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled[A]
}
