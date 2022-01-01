package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules._

private[coc] trait SkillImprovementBehavior {
  self: Skill
    with SkillSuccessCheck
    with SkillWithImprovedValue
    with SkillImprovable =>

  override def improvedValue: Int = 0

  override def successCheck: Boolean = false

  override def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved = {
    SkillImprovement(this).result
  }
}
