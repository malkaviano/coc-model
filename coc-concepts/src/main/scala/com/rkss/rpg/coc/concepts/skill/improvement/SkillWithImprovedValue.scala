package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill.Skill

private[coc] trait SkillWithImprovedValue { self: Skill =>
  def improvedValue: Int
}
