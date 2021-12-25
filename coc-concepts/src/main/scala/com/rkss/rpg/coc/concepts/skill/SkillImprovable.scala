package com.rkss.rpg.coc.concepts.skill

trait SkillImprovable { this: Skill =>
  def usedWithSuccess: Boolean

  def improvedValue: Int
}
