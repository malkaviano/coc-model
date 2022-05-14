package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

// TODO: Use age
final case class HumanMovementRate(
    private val strength: Characteristic[Strength.type],
    private val dexterity: Characteristic[Dexterity.type],
    private val size: Characteristic[Size.type]
) {
  def current: Int = {
    if (strength.value() >= size.value() || dexterity.value() >= size.value()) {
      if (strength.value() > size.value() && dexterity.value() > size.value()) {
        9
      } else {
        8
      }
    } else {
      7
    }
  }
}
