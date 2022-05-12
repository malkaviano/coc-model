package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.fundamentals._

final case class SkillImpl[A <: ImprovableSkillName](
    override val name: A,
    baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends BaseRollable[A](name, baseValue + occupationPoints + personalPoints)
    with BasicSkill[A]
    with SkillWithPointsAllocation
    with SkillRollBehavior[A]
