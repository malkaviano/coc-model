package com.rkss.rpg.coc.concepts.skillroll

trait Rollable {
  def value(difficulty: SkillRollDifficultyLevel): Int
}
