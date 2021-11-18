package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.traits.Attribute._

final case class CreditRating(override val value: Int)
    extends Attribute("Credit Rating", value)
    with ChangeValue[CreditRating] {
  override def -(minus: Int): CreditRating = {
    this.copy(value - minus)
  }

  override def +(plus: Int): CreditRating = {
    this.copy(value + plus)
  }
}
