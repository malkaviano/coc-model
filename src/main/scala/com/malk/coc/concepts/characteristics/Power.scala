package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Power(override val value: Int)
    extends Characteristic("PWR", value)
    with Modifications[Power] {
  override def -(other: Modification[Power]): Power = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Power]): Power = {
    this.copy(this.value + other.value)
  }
}
