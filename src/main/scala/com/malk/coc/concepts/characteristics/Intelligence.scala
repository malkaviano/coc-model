package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.Modifications
import com.malk.coc.helpers.CharacteristicModifications._

final case class Intelligence(override val value: Int)
    extends Characteristic("INT", value)
    with Modifications[Intelligence] {
  override def -(other: Modification[Intelligence]): Intelligence = {
    this.copy(this.value - other.value)
  }

  override def +(other: Modification[Intelligence]): Intelligence = {
    this.copy(this.value + other.value)
  }
}
