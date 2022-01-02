package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.rules.SkillRollValue
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty
import com.rkss.rpg.coc.concepts.skill.improvement.SkillWithImprovedValue
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation

private[coc] trait WithDifficultyValueBehavior {
  self: EntityWithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    val allocated = self match {
      case skillWithAllocatedPoints: SkillWithPointsAllocation =>
        skillWithAllocatedPoints.occupationPoints + skillWithAllocatedPoints.personalPoints
      case _ => 0
    }

    val improved = self match {
      case skillWithImprovedValue: SkillWithImprovedValue =>
        skillWithImprovedValue.improvedValue
      case _ => 0
    }

    SkillRollValue(baseValue + allocated + improved).value(difficulty)
  }
}
