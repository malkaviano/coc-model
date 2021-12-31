package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.rules.SkillImprovement

final case class FakeSkillImprovement(
    override val name: String,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends FakeSkill(name, baseValue, occupationPoints, personalPoints)
    with SkillImprovement