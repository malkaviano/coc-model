package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._

trait SuccessDevelopSkill
    extends Skill
    with SkillUsedCheck
    with SkillDevelopment {
  override def succeeded: Boolean = ???

  override def improvedValue: Int = ???

  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue + improvedValue).value(difficulty)
  }
}
