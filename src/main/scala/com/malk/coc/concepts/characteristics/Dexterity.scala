package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Dexterity(override val value: Int) extends Characteristic {
  override val name = "DEX"

  override def +(plus: Int): Dexterity = {
    this.copy(value + plus)
  }
}