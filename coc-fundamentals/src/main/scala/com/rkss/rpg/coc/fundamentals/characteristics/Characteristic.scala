package com.rkss.rpg.coc.fundamentals.characteristics

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.rules.skill.behaviors._

final case class Characteristic[A <: CharacteristicName](
    override val name: A,
    override val baseValue: Int
) extends GenericCharacteristic[A]
    with WithModificationValueBehavior[A]
    with WithDifficultyValueBehavior
    with SkillRollBehavior[A]
    with PushableSkillRollBehavior[A]
