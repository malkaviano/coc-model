package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Constitution(override val value: Int) extends Characteristic("CON", value) {
  override def +(plus: Int): Constitution = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Constitution = {
    this + -minus
  }
}