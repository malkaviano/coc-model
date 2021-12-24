package com.rkss.rpg.coc.props.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._

class FakeSkill(
    override val name: String,
    override val baseValue: Int
) extends Skill {

  override def value(difficulty: SkillRollDifficultyLevel): Int = {
    baseValue
  }
}
