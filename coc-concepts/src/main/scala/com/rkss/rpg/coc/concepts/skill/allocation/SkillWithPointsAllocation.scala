package com.rkss.rpg.coc.concepts.skill.allocation

import com.rkss.rpg.coc.concepts.skill.Skill

trait SkillWithPointsAllocation { self: Skill =>
  def occupationPoints: Int

  def personalPoints : Int
}
