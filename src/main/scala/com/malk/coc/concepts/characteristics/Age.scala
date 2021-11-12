package com.malk.coc.concepts.characteristics

import com.malk.coc.traits.Characteristic

case class Age(override val value: Int) extends Characteristic {
  override val name: String = "Age"

  override def +(plus: Int): Age = {
    this.copy(value + plus)
  }
}