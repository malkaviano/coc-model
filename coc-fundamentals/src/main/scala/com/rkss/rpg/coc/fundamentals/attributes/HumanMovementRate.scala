package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.attributes._

final case class HumanMovementRate(
    private val strength: Characteristic[Strength.type],
    private val dexterity: Characteristic[Dexterity.type],
    private val size: Characteristic[Size.type]
) extends MovementRate {
  override def current: Int = {
    if (strength.value() >= size.value() || dexterity.value() >= size.value()) {
      if (
        strength.value() > size.value() && dexterity.value() > size.value()
      ) {
        9
      } else {
        8
      }
    } else {
      7
    }
  }
}
