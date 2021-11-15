package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Education(override val value: Int)
    extends Characteristic("EDU", value)
    with Modifications[Education] {
  override def -(other: Modification[Education]): Education = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Education]): Education = {
    this.copy(this.value + other.value)
  }
}
