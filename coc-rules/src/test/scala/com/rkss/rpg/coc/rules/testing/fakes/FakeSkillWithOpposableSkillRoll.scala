package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.rules.behaviors.OpposedSkillRollBehavior
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollOpposable

final case class FakeSkillWithOpposableSkillRoll(
    override val name: String,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends FakeSkill(name, baseValue, occupationPoints, personalPoints)
    with SkillRollOpposable
    with OpposedSkillRollBehavior
