package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.rules.behaviors._

final case class Characteristic(
    override val name: CharacteristicName,
    override val baseValue: Int
) extends PrimaryCharacteristic
    with WithModificationValueBehavior
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with PushableSkillRollBehavior
