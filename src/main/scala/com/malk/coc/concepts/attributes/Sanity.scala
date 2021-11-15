package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.helpers.WithValueMathHelper

final case class Sanity(override val value: Int)
    extends Attribute("SAN", value)
    with WithValueMathHelper[Sanity] {
  override def -(minus: Int): Sanity = ???
  override def +(plus: Int): Sanity = ???
}
