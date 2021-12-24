package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.Skill

trait SkillUsedCheck { this: Skill =>
  def succeeded: Boolean
}
