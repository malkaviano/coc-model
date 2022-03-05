package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.commons._

trait Skill[+A <: SkillName] extends SkillRollCheckable[A] {
  def tags: Seq[SkillTag]
}

trait BasicSkill[A <: SkillName]
    extends Skill[A]
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillSuccessMark
    with SkillImprovable[A]
    with EntityWithModifiableValue[A]

trait SystemSkill[A <: SkillName]
    extends Skill[A]
    with EntityWithModifiableValue[A]
