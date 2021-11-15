package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Dexterity(override val value: Int)
    extends Characteristic("DEX", value)
    with Modifications[Dexterity] {
  override def -(other: Modification[Dexterity]): Dexterity = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Dexterity]): Dexterity = {
    this.copy(this.value + other.value)
  }
}
