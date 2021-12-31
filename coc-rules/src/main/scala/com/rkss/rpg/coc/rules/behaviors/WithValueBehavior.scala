package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.RollableEntity
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.rules.SkillRollValue

trait WithValueBehavior { self: RollableEntity =>
  def value(
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }
}
