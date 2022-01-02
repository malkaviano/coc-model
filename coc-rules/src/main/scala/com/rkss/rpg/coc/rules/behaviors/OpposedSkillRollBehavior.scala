package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.rules._
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollOpposable
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice

private[coc] trait OpposedSkillRollBehavior {
  self: Skill with SkillRollOpposable with SkillRollBehavior =>
  override def rollOpposedBy(
      opposedBy: EntityWithDifficultyValue,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled = {
    lastSkillRolled = Option(
      OpposedSkillRoll(this, opposedBy, bonusDice, penaltyDice).result
    )

    lastSkillRolled.get
  }
}
