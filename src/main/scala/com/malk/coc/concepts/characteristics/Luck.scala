package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Luck(override val value: Int) extends Characteristic {
  override val name = "Luck"

  override def +(plus: Int): Luck = {
    this.copy(value + plus)
  }
}