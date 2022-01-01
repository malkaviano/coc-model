package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._

private[coc] trait SkillImprovementBehavior {
  self: Skill with SkillSuccessCheck with SkillWithImprovedValue =>

  override def improvedValue: Int = 0

  override def successCheck: Boolean = false
}
