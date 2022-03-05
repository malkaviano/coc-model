package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.behaviors._
import com.rkss.rpg.coc.concepts.commons._

final case class FakeGenericCharacteristic[A <: CharacteristicName](
    override val name: A,
    override val baseValue: Int
) extends Characteristic[A]
    with EntityWithModifiableValue[A]
    with WithValueModificationBehavior[A]
    with WithDifficultyValueBehavior
    with SkillRollBehavior[A]
