package com.rkss.rpg.coc.concepts.roll

trait Rollable {
  def value(difficulty: SkillRollDifficultyLevel): Int
}
