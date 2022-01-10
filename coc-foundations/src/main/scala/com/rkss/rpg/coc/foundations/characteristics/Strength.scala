package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.Identification
import com.rkss.rpg.coc.concepts.CharacteristicStrength

final case class Strength(override val baseValue: Int)
    extends PrimaryCharacteristic
    with WithModificationValueBehavior
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with PushableSkillRollBehavior {
  override val id: Identification = CharacteristicStrength
}
