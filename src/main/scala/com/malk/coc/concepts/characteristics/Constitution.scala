package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Constitution(override val value: Int) extends Characteristic {
  override val name = "CON"

  override def +(plus: Int): Constitution = {
    this.copy(value + plus)
  }
}