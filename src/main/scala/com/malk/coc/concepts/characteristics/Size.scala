package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Size(override val value: Int)
    extends Characteristic("SIZ", value)
    with Modifications[Size] {
  override def -(other: Modification[Size]): Size = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Size]): Size = {
    this.copy(this.value + other.value)
  }
}
