package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill._

trait SkillSuccessCheckable { self: Skill[_] =>
  def checkUsedWithSuccess(): Unit
}
