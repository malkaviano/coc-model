package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._

trait SkillImprovable[A <: SkillName] {
  self: Skill[A] with SkillSuccessMark with SkillWithImprovement =>

  def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved[A]
}
