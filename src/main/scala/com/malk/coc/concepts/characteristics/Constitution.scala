package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Constitution(override val value: Int)
    extends Characteristic("CON", value)
    with MathOperations[Constitution] {
  override def -(other: Constitution): Constitution = {
    this.copy(this.value - other.value)
  }

  override def +(other: Constitution): Constitution = {
    this.copy(this.value + other.value)
  }
}
