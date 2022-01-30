package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._

trait SkillImprovable {
  self: Skill[_] with SkillSuccessMark with SkillWithImprovement =>

  def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved
}
