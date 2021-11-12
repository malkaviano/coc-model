package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Strength(override val value: Int) extends Characteristic {
  override val name = "STR"

  override def +(plus: Int): Strength = {
    this.copy(value + plus)
  }
}