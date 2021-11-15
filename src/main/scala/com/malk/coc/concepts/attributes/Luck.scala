package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.helpers.WithValueMathHelper

final case class Luck(override val value: Int)
    extends Attribute("Luck", value)
    with WithValueMathHelper[Luck] {
  override def -(minus: Int): Luck = {
    this.copy(value - minus)
  }

  override def +(plus: Int): Luck = {
    this.copy(value + plus)
  }
}
