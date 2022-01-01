package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill.Skill

trait SkillSuccessCheckable { self: Skill =>
  def checkUsedWithSuccess(): Unit
}
