package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.skill.behaviors._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.allocation._

final class BasicSkill[A <: SkillName] private[coc](
    override val name: SkillName,
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends Skill[A]
    with SkillWithPointsAllocation
    with SkillSuccessCheck
    with SkillSuccessCheckable
    with SkillWithImprovedValue
    with SkillImprovable
    with SkillRollBehavior
    with SkillSuccessfullyUsedBehavior
    with SkillPushable
    with PushableSkillRollBehavior
    with SkillImprovementBehavior
    with WithDifficultyValueBehavior
    with WithGenericModificationValueBehavior[A]
