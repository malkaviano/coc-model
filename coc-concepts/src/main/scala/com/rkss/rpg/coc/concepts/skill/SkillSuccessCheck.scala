package com.rkss.rpg.coc.concepts.skill

private[coc] trait SkillSuccessCheck { self: Skill =>
  def successCheck: Boolean
}
