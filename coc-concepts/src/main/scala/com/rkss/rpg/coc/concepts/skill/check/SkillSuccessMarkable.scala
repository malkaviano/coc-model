package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill._

trait SkillSuccessMarkable { self: Skill[ImprovableSkillName] =>
  def markUsedWithSuccess(): Unit
}
