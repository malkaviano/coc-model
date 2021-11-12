package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

case class Education(override val value: Int) extends Characteristic {
  override val name = "EDU"

  override def +(plus: Int): Education = {
    this.copy(value + plus)
  }
}