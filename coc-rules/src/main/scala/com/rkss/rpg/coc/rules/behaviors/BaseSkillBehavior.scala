package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.SkillRollValue

trait BaseSkillBehavior extends Skill {
  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }

  override def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  ): SkillRollResult = ???
}
