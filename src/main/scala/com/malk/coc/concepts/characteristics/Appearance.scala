package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Appearance(override val value: Int)
    extends Characteristic("APP", value)
    with MathOperations[Appearance] {
  override def -(other: Appearance): Appearance = {
    this.copy(this.value - other.value)
  }

  override def +(other: Appearance): Appearance = {
    this.copy(this.value + other.value)
  }
}
