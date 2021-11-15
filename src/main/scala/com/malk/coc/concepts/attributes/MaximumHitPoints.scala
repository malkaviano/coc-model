package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.concepts.abstractions.Body

final case class MaximumHitPoints(
  private val body: Body
) extends Attribute {
  override val name = "Maximum Hit Points"

  override val value: Int = (body.constitution.value + body.size.value) / 10
}