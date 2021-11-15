package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Appearance(override val value: Int)
    extends Characteristic("APP", value)
    with Modifications[Appearance] {
  override def -(other: Modification[Appearance]): Appearance = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Appearance]): Appearance = {
    this.copy(this.value + other.value)
  }
}
