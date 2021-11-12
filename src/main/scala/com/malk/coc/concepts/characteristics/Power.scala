package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Power(override val value: Int) extends Characteristic {
  override val name = "PWR"

  override def +(plus: Int): Power = {
    this.copy(value + plus)
  }
}