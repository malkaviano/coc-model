package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules.behaviors.WithDifficultyValueBehavior
import com.rkss.rpg.coc.rules.SkillRollValue
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty

private[coc] trait SkillWithDifficultyValueBehavior extends WithDifficultyValueBehavior { self: Skill =>
  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue + occupationPoints + personalPoints).value(difficulty)
  }
}
