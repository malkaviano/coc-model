package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._
import com.malk.coc.traits.Characteristic

final case class Strength(override val value: Int)
    extends Characteristic("STR", value)
    with Modifications[Strength] {
  override def +(other: Modification[Strength]): Strength = {
    this.copy(this.value + other.value)
  }

  override def -(other: Modification[Strength]): Strength = {
    this.copy(this.value - other.value)
  }
}
