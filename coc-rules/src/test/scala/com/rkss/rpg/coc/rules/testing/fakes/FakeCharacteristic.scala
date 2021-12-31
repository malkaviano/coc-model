package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.rules.behaviors._

final case class FakeCharacteristic(
    override val baseValue: Int
) extends PrimaryCharacteristic
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with PushableSkillRollBehavior {
  override val name: String = "FakeCharacteristic"
}
