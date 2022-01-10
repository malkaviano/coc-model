package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.improvement._

final case class FakeSkillImprovable(
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends FakeSkill(baseValue, occupationPoints, personalPoints)
    with SkillSuccessCheck
    with SkillSuccessCheckable
    with SkillSuccessfullyUsedBehavior
    with SkillWithImprovedValue
    with SkillImprovable
    with SkillImprovementBehavior
