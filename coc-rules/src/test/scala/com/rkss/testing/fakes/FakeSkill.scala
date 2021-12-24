package com.rkss.rpg.coc.props

import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDifficultyLevel
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.SkillDevelopment

final case class FakeSkill(
    override val name: String,
    override val baseValue: Int,
    override val succeeded: Boolean
) extends Skill
    with SkillUsedCheck
    with SkillDevelopment {

  override def value(difficulty: SkillRollDifficultyLevel): Int = 25
}
