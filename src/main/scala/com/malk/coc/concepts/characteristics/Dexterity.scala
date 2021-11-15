package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic
import com.malk.coc.traits.Characteristic.MathOperations

final case class Dexterity(override val value: Int)
    extends Characteristic("DEX", value)
    with MathOperations[Dexterity] {
  override def -(other: Dexterity): Dexterity = {
    this.copy(this.value - other.value)
  }

  override def +(other: Dexterity): Dexterity = {
    this.copy(this.value + other.value)
  }
}
