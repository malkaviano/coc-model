package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.improvement._

trait Skill[A <: SkillName] extends SkillRollCheckable[A] {
  def tags: Seq[SkillTag]
}

trait BasicSkill[A <: SkillName]
    extends Skill[A]
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillSuccessMark
    with SkillImprovable[A]

trait CombatSkill[A <: SkillName]
    extends Skill[A]
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillSuccessMark
    with SkillImprovable[A]

trait SystemSkill[A <: SkillName] extends Skill[A]
