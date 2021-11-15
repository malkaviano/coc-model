package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Size(override val value: Int)
    extends Characteristic("SIZ", value) {
  override def +(plus: Int): Size = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Size = {
    this + -minus
  }
}
