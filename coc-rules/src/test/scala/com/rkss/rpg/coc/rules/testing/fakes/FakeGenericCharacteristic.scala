package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.rules.skill.behaviors._
import com.rkss.rpg.coc.concepts.characteristic._

final case class FakeGenericCharacteristic[A <: CharacteristicName](
    override val name: A,
    override val baseValue: Int
) extends Characteristic[A]
    with WithModificationValueBehavior[A]
    with WithDifficultyValueBehavior
    with SkillRollBehavior[A]
    with PushableSkillRollBehavior[A]
