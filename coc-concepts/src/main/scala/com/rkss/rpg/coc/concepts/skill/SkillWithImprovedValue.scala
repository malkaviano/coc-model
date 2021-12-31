package com.rkss.rpg.coc.concepts.skill

private[coc] trait SkillWithImprovedValue { self: Skill =>
  def improvedValue: Int
}
