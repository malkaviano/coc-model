package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute
import com.malk.coc.abstractions.Body

final case class MaximumHitPoints(
  private val body: Body
) extends Attribute("Maximum Hit Points", 0) {
  override val value: Int = (body.constitution.value + body.size.value) / 10
}