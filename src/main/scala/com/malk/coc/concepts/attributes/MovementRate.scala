package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.helpers.WithValueMathHelper

final case class MovementRate(override val value: Int)
    extends Attribute("MOV", value)
    with WithValueMathHelper[MovementRate] {
  override def -(minus: Int): MovementRate = ???
  override def +(plus: Int): MovementRate = ???
}
