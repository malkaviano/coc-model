package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

case class Size(override val value: Int) extends Characteristic {
  override val name = "SIZ"

  override def +(plus: Int): Size = {
    this.copy(value + plus)
  }
}
