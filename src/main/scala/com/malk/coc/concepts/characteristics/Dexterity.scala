package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Dexterity(override val value: Int) extends Characteristic("DEX", value) {
  override def +(plus: Int): Dexterity = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Dexterity = {
    this + -minus
  }
}