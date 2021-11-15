package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Power(override val value: Int) extends Characteristic("PWR", value) {
  override def +(plus: Int): Power = {
    this.copy(value + plus)
  }

  override def -(minus: Int): Power = {
    this + -minus
  }
}