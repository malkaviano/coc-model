package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute

final case class Sanity(override val value: Int) extends Attribute {
  override val name: String = "SAN"
}