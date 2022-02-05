package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.behaviors._

final case class BasicSkill[A <: ImprovableSkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends Skill[A]
    with SkillWithPointsAllocation
    with SkillSuccessMark
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillImprovable[A]
    with SkillRollBehavior[A]
    with SkillSuccessfullyUsedBehavior
    with SkillPushable[A]
    with PushableSkillRollBehavior[A]
    with SkillImprovementBehavior[A]
    with WithDifficultyValueBehavior
    with WithModificationValueBehavior[A]
