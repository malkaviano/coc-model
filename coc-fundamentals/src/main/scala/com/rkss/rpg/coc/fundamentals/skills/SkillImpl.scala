package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.roll._

final case class SkillImpl[A <: ImprovableSkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends Skill[A](name, baseValue, occupationPoints, personalPoints)
    with SkillRollBehavior[A]
