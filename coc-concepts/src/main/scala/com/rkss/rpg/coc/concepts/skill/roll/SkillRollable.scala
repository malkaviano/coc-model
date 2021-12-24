package com.rkss.rpg.coc.concepts.skill.roll

trait SkillRollable {
  def value(difficulty: SkillRollDifficultyLevel): Int
}
