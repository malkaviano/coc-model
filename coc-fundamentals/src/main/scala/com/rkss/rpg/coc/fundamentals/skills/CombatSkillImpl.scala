package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.behaviors._

final case class CombatSkillImpl[A <: CombatSkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends CombatSkill[A]
    with SkillWithPointsAllocation
    with SkillRollBehavior[A]
    with SkillSuccessfullyUsedBehavior
    with SkillImprovementBehavior[A]
    with WithDifficultyValueBehavior
    with WithValueModificationBehavior[A]
