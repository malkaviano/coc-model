package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.rules.SkillImprovement

final case class FakeSkillImprovement(
    override val name: String,
    override val baseValue: Int,
    override val regular: Int,
    override val hard: Int,
    override val extreme: Int
) extends FakeSkill(name, baseValue, regular, hard, extreme)
    with SkillImprovement