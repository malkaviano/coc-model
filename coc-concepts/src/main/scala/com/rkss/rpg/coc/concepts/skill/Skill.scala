package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.roll._

trait Skill[+A <: SkillName] extends SkillRollCheckable[A] {
  def tags: Seq[SkillTag]
}

trait BasicSkill[A <: ImprovableSkillName] extends Skill[A]
