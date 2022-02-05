package com.rkss.rpg.coc.behaviors.skill.facts

import com.rkss.rpg.coc.concepts.skill.roll._

private[behaviors] final case class SkillRollValue(val value: Int) {
  def value(
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    difficulty match {
      case RegularDifficulty => value
      case HardDifficulty    => value / 2
      case ExtremeDifficulty => value / 5
    }
  }
}
