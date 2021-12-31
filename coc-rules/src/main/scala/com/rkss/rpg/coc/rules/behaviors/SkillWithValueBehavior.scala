package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules.behaviors.WithValueBehavior

trait SkillWithValue extends WithValueBehavior { self: Skill =>
  override def value(
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    baseValue + occupationPoints + personalPoints
  }
}
