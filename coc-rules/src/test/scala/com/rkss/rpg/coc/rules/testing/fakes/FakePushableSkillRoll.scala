package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class FakePushableSkillRoll(
    override val name: String,
    override val baseValue: Int,
    override val regular: Int,
    override val hard: Int,
    override val extreme: Int
) extends FakeSkill(name, baseValue, regular, hard, extreme)
    with SkillRollBehavior
    with SkillPushable
    with PushableSkillRollBehavior