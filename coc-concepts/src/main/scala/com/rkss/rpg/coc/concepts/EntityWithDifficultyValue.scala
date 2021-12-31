package com.rkss.rpg.coc.concepts

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel

trait EntityWithDifficultyValue extends EntityWithBaseValue {
  def value(
      difficulty: SkillRollDifficultyLevel
  ): Int
}
