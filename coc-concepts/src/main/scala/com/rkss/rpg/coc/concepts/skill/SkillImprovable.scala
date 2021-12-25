package com.rkss.rpg.coc.concepts.skill

trait SkillImprovable { self: Skill =>
  def usedWithSuccess: Boolean

  def tickUsedWithSuccess(): Unit

  def improvedValue: Int
}
