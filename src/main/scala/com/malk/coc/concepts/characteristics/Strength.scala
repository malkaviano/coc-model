package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Strength(override val value: Int)
    extends Characteristic("STR", value)
    with MathOperations[Strength] {
  override def -(other: Strength): Strength = {
    this.copy(this.value - other.value)
  }

  override def +(other: Strength): Strength = {
    this.copy(this.value + other.value)
  }
}
