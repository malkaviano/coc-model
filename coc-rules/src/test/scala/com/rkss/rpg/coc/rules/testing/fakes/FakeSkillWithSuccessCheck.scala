package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.skill.improvement._

final case class FakeSkillWithSuccessCheck(
    override val name: String,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0,
    override val successCheck: Boolean = false
) extends FakeSkill(name, baseValue, occupationPoints, personalPoints)
    with SkillSuccessCheck