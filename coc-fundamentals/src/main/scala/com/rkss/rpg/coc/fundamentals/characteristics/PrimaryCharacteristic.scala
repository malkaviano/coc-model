package com.rkss.rpg.coc.fundamentals.characteristics

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.behaviors._
import com.rkss.rpg.coc.concepts.internal._

final case class PrimaryCharacteristic[A <: CharacteristicName](
    override val name: A,
    override val baseValue: Int
) extends Characteristic[A]
    with WithModifiableValue[A]
    with WithValueModificationBehavior[A]
    with WithDifficultyValueBehavior
    with SkillRollBehavior[A]
