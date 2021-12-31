package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.rules.SkillRollValue

private[coc] trait WithDifficultyValueBehavior { self: EntityWithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }
}
