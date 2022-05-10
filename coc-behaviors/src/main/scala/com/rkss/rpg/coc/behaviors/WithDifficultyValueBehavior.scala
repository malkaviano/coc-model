package com.rkss.rpg.coc.behaviors

import com.rkss.rpg.coc.behaviors.extractor._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.concepts.internal._

private[coc] trait WithDifficultyValueBehavior {
  self: WithDifficultyValue =>
  def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    DifficultyValueExtractor.value(
      baseValue + allocated + improved + modification,
      difficulty
    ) match {
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
    case withModificationValue: WithModificationValue =>
      withModificationValue.modificationValue
    case _ => 0
  }
}
