package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.rules.skill._
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty
import com.rkss.rpg.coc.concepts.skill.improvement.SkillWithImprovedValue
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation
import com.rkss.rpg.coc.concepts.EntityWithModificationValue

private[coc] trait WithDifficultyValueBehavior {
  self: EntityWithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue + allocated + improved + modification)
      .value(difficulty)
  }

  private def allocated: Int = self match {
    case skillWithAllocatedPoints: SkillWithPointsAllocation =>
      skillWithAllocatedPoints.occupationPoints + skillWithAllocatedPoints.personalPoints
    case _ => 0
  }

  private def improved: Int = self match {
    case skillWithImprovedValue: SkillWithImprovedValue =>
      skillWithImprovedValue.improvedValue
    case _ => 0
  }

  private def modification: Int = self match {
    case withModificationValue: EntityWithModificationValue =>
      withModificationValue.modificationValue
    case _ => 0
  }
}
