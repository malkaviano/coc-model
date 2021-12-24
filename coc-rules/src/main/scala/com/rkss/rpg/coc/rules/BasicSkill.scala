package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.SkillRollValue

trait BasicSkill extends Skill {
  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }
}
