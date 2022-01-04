package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._

trait SkillImprovable {
  self: Skill with SkillSuccessCheck with SkillWithImprovedValue =>

  def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved
}
