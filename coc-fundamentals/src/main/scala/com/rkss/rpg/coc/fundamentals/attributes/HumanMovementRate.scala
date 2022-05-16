package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final case class HumanMovementRate(
    private val strength: Characteristic[Strength.type],
    private val dexterity: Characteristic[Dexterity.type],
    private val size: Characteristic[Size.type],
    private val age: Age
) {
  private def ageModifier: Int = {
    age.current match {
      case x if x >= 40 => ((x - 40) / 10) + 1
      case _            => 0
    }
  }

  def current: Int = {
    val result =
      if (
        strength.value() >= size.value() || dexterity.value() >= size.value()
      ) {
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

    result - ageModifier
  }
}
