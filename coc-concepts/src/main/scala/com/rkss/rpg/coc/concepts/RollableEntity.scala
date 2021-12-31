package com.rkss.rpg.coc.concepts

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel

trait RollableEntity {
  def baseValue: Int

  def value(
      difficulty: SkillRollDifficultyLevel
  ): Int
}
