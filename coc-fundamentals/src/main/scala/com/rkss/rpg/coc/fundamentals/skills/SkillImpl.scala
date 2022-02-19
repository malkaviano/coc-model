package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.behaviors._

final case class SkillImpl[A <: ImprovableSkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends BasicSkill[A]
    with SkillWithPointsAllocation
    with SkillRollBehavior[A]
    with SkillSuccessfullyUsedBehavior
    with SkillImprovementBehavior[A]
    with WithDifficultyValueBehavior
    with WithValueModificationBehavior[A]
