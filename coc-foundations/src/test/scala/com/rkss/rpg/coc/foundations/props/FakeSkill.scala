package com.rkss.rpg.coc.foundations.props

import com.rkss.rpg.coc.foundations.helpers.SkillDevelopment
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill._

final case class FakeSkill() extends Skill with SkillDevelopment {
  override def name: String = "FakeSkill"

  override def baseValue: Int = ???

  override def value(difficulty: SkillRollDifficultyLevel): Int = 25
}