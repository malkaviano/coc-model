package com.rkss.rpg.coc.concepts.skillroll

trait SkillRollable {
  def value(difficulty: SkillRollDifficultyLevel): Int
}
