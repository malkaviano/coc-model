package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.RollableEntity
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel

trait WithValueBehavior { self: RollableEntity =>
  def value(
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    baseValue
  }
}
