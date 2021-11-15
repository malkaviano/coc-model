package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Intelligence(override val value: Int) extends Characteristic("INT", value) {
  override def +(plus: Int): Intelligence = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Intelligence = {
    this + -minus
  }
}