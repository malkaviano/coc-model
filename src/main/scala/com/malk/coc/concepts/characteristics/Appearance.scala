package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Appearance(override val value: Int) extends Characteristic("APP", value) {
  override def +(plus: Int): Appearance = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Appearance = {
    this + -minus
  }
}