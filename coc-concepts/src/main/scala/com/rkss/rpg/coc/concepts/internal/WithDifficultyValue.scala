package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.coc.concepts.roll._

trait WithDifficultyValue extends WithBaseValue {
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int
}
