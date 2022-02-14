package com.rkss.rpg.coc.behaviors.extractor

import com.rkss.rpg.coc.concepts.skill.roll._

private[behaviors] object DifficultyValueExtractor {
  def value(
      base: Int,
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    difficulty match {
      case RegularDifficulty => base
      case HardDifficulty    => base / 2
      case ExtremeDifficulty => base / 5
    }
  }
}
