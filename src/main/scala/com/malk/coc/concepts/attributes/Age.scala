package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.traits.Attribute.ChangeValue

final case class Age(override val value: Int)
    extends Attribute("Age", value)
    with ChangeValue[Age] {
  override def -(minus: Int): Age = {
    this.copy(value - minus)
  }

  override def +(plus: Int): Age = {
    this.copy(value + plus)
  }
}
