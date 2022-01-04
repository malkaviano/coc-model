package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill.Skill

trait SkillSuccessCheck { self: Skill =>
  def successCheck: Boolean
}
