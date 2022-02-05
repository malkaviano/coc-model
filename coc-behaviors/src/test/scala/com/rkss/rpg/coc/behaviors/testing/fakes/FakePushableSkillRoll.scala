package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._

final case class FakePushableSkillRoll[A <: SkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends FakeSkill(name, baseValue, occupationPoints, personalPoints)
    with SkillRollBehavior[A]
    with SkillPushable[A]
    with PushableSkillRollBehavior[A]