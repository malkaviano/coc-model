package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.rules.behaviors._

final case class Dexterity(override val baseValue: Int)
    extends PrimaryCharacteristic
    with WithModificationValueBehavior
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with PushableSkillRollBehavior
