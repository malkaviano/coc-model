package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.internal._

trait Skill[+A <: SkillName] extends SkillRollCheckable[A] {
  def tags: Seq[SkillTag]
}

trait BasicSkill[A <: ImprovableSkillName]
    extends Skill[A]
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillSuccessMark
    with SkillImprovable[A]
    with WithModifiableValue[A]

trait SystemSkill[A <: SkillName] extends Skill[A] with WithModifiableValue[A]
