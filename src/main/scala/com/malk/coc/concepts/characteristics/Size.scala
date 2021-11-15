package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Size(override val value: Int)
    extends Characteristic("SIZ", value)
    with MathOperations[Size] {
  override def -(other: Size): Size = {
    this.copy(this.value - other.value)
  }

  override def +(other: Size): Size = {
    this.copy(this.value + other.value)
  }
}
