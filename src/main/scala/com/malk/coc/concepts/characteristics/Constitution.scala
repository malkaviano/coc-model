package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Constitution(override val value: Int)
    extends Characteristic("CON", value)
    with Modifications[Constitution] {
  override def -(other: Modification[Constitution]): Constitution = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Constitution]): Constitution = {
    this.copy(this.value + other.value)
  }
}
