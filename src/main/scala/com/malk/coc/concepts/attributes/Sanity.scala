package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.concepts.abstractions.Brain

final case class Sanity(brain: Brain) extends Attribute {
  override val name: String = "SAN"

  override val value: Int = brain.power.value
}