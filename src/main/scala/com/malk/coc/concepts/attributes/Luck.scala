package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.traits.Attribute.ChangeValue

final case class Luck(override val value: Int)
    extends Attribute("Luck", value)
    with ChangeValue[Luck] {
  override def -(minus: Int): Luck = {
    this.copy(value - minus)
  }

  override def +(plus: Int): Luck = {
    this.copy(value + plus)
  }
}
