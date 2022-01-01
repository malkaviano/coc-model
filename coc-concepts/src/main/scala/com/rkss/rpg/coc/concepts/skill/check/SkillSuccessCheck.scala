package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill.Skill

private[coc] trait SkillSuccessCheck { self: Skill =>
  def successCheck: Boolean
}
