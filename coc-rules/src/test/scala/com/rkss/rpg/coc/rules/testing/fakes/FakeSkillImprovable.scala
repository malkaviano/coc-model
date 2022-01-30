package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.rules.skill.behaviors._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill._

final case class FakeSkillImprovable[A <: SkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends FakeSkill(name, baseValue, occupationPoints, personalPoints)
    with SkillSuccessMark
    with SkillSuccessMarkable
    with SkillSuccessfullyUsedBehavior
    with SkillWithImprovement
    with SkillImprovable
    with SkillImprovementBehavior[A]
