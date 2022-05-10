package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty

trait WithDifficultyValue extends WithBaseValue {
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int
}
