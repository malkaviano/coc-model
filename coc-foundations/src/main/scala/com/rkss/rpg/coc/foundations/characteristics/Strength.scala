package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.rules.behaviors.BaseSkillBehavior

final case class Strength(override val baseValue: Int)
    extends PrimaryCharacteristic
    with BaseSkillBehavior {
  override val name: String = "Strength"
}
