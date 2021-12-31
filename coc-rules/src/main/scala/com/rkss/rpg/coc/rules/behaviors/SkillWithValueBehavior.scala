package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules.behaviors.WithValueBehavior
import com.rkss.rpg.coc.rules.SkillRollValue

trait SkillWithValue extends WithValueBehavior { self: Skill =>
  override def value(
      difficulty: SkillRollDifficultyLevel
  ): Int = {
    SkillRollValue(baseValue + occupationPoints + personalPoints).value(difficulty)
  }
}
