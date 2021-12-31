package com.rkss.rpg.coc.concepts

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty

trait EntityWithDifficultyValue extends EntityWithBaseValue {
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int
}
