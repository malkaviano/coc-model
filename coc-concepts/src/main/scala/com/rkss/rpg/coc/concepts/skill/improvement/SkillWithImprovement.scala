package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill._

trait SkillWithImprovement { self: Skill[_] =>
  def improvement: Int
}
