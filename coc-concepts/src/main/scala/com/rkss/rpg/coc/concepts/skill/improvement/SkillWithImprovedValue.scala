package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill._

trait SkillWithImprovedValue { self: Skill[_] =>
  def improvedValue: Int
}
