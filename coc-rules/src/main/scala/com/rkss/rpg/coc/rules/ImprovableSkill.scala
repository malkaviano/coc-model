package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._

trait ImprovableSkill
    extends Skill
    with SkillImprovable
    with SkillImprovement {
  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue + improvedValue).value(difficulty)
  }
}
