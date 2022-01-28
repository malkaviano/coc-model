package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.rules.skill.behaviors._
import com.rkss.rpg.coc.concepts.characteristic._

final case class FakeCharacteristic(
    override val name: CharacteristicName,
    override val baseValue: Int
) extends PrimaryCharacteristic
    with WithModificationValueBehavior
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with PushableSkillRollBehavior