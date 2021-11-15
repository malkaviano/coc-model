package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Intelligence(override val value: Int)
    extends Characteristic("INT", value)
    with MathOperations[Intelligence] {
  override def -(other: Intelligence): Intelligence = {
    this.copy(this.value - other.value)
  }

  override def +(other: Intelligence): Intelligence = {
    this.copy(this.value + other.value)
  }
}
