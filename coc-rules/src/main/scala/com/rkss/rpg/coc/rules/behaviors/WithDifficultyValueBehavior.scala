package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.rules.SkillRollValue
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty

private[coc] trait WithDifficultyValueBehavior { self: EntityWithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }
}
