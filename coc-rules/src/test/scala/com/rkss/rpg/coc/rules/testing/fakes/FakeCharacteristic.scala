package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.rules.behaviors._

final case class FakeCharacteristic(
    override val baseValue: Int
) extends PrimaryCharacteristic
    with WithModificationValueBehavior
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with PushableSkillRollBehavior {
  override val id: Identification = CharacteristicStrength
}
