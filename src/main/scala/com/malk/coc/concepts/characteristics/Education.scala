package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Education(override val value: Int)
    extends Characteristic("EDU", value)
    with MathOperations[Education] {
  override def -(other: Education): Education = {
    this.copy(this.value - other.value)
  }

  override def +(other: Education): Education = {
    this.copy(this.value + other.value)
  }
}
