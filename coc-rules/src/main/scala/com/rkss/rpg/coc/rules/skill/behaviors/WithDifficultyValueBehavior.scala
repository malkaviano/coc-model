package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.rules.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.concepts._

private[coc] trait WithDifficultyValueBehavior {
  self: EntityWithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue + allocated + improved + modification)
      .value(difficulty) match {
      case value if value >= 0 => value
      case _                   => 0
    }
  }

  private def allocated: Int = self match {
    case skillWithAllocatedPoints: SkillWithPointsAllocation =>
      skillWithAllocatedPoints.occupationPoints + skillWithAllocatedPoints.personalPoints
    case _ => 0
  }

  private def improved: Int = self match {
    case skillWithImprovement: SkillWithImprovement =>
      skillWithImprovement.improvement
    case _ => 0
  }

  private def modification: Int = self match {
    case withModificationValue: EntityWithModificationValue =>
      withModificationValue.modificationValue
    case _ => 0
  }
}
