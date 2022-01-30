package com.rkss.rpg.coc.concepts.skill.allocation

import com.rkss.rpg.coc.concepts.skill._

trait SkillWithPointsAllocation { self: Skill[_] =>
  def occupationPoints: Int

  def personalPoints : Int
}
