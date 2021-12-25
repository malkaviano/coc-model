package com.rkss.rpg.coc.concepts.skill

trait SkillImprovable { self: Skill =>
  def usedWithSuccess: Boolean

  def improvedValue: Int

  def tickSuccessfullyUsed(): Unit

  def improveSkill(): Unit
}
