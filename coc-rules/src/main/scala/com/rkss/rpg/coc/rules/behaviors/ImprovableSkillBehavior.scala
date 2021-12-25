package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules._

trait ImprovableSkillBehavior extends BaseSkillBehavior with SkillImprovable with SkillImprovement {
  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue + improvedValue).value(difficulty)
  }
}
