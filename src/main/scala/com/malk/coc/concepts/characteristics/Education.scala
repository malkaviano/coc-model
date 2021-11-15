package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Education(override val value: Int) extends Characteristic("EDU", value) {
  override def +(plus: Int): Education = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Education = {
    this + -minus
  }
}