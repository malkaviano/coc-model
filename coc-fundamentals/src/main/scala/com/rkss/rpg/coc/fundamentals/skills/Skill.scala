package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.fundamentals._

trait Skill[A <: SkillName] extends BaseRollable[A] {
  def tags: Seq[SkillTag]
}
