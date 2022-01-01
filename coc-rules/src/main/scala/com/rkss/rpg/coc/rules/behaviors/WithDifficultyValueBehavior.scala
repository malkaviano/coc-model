package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.rules.SkillRollValue
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.skill.improvement.SkillWithImprovedValue

private[coc] trait WithDifficultyValueBehavior { self: EntityWithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    val allocated = if (self.isInstanceOf[Skill]) {
      self.asInstanceOf[Skill].occupationPoints + self.asInstanceOf[Skill].personalPoints
    } else {
      0
    }

    val improved = if (self.isInstanceOf[SkillWithImprovedValue]) {
      self.asInstanceOf[SkillWithImprovedValue].improvedValue
    } else {
      0
    }

    SkillRollValue(baseValue + allocated + improved).value(difficulty)
  }
}
