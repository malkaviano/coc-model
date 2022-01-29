package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill._

trait SkillSuccessCheck { self: Skill[_] =>
  def successCheck: Boolean
}
