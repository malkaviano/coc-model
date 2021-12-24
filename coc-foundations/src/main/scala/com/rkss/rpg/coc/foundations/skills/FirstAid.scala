package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.foundations.helpers.SkillDevelopment

trait FirstAid extends Skill with SkillPushable with SkillDevelopment {
  override lazy val name: String = "First Aid"

  override lazy val baseValue: Int = 30

  override def value(difficulty: SkillRollDifficultyLevel): Int = ???
}

object FirstAid {
  def create: Skill = {
    new FirstAid {}
  }
}