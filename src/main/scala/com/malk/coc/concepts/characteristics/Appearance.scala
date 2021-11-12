package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

final case class Appearance(override val value: Int) extends Characteristic {
  override val name: String = "APP"

  override def +(plus: Int): Appearance = {
    this.copy(value + plus)
  }
}