package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Strength(override val value: Int) extends Characteristic("STR", value) {
  override def +(plus: Int): Strength = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Strength = {
    this + -minus
  }
}