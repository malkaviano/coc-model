package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Power(override val value: Int)
    extends Characteristic("PWR", value)
    with MathOperations[Power] {
  override def -(other: Power): Power = {
    this.copy(this.value - other.value)
  }

  override def +(other: Power): Power = {
    this.copy(this.value + other.value)
  }
}
