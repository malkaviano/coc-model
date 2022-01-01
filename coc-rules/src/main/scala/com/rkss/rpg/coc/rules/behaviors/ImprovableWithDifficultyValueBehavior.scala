package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.SkillRollValue
import com.rkss.rpg.coc.concepts.skill.improvement._

private[coc] trait ImprovableWithDifficultyValueBehavior
    extends SkillWithDifficultyValueBehavior {
  self: Skill with SkillWithImprovedValue =>
  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(
      super.value() + improvedValue
    )
      .value(difficulty)
  }
}
