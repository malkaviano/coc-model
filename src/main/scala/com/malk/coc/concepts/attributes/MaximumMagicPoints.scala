package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute

final case class MaximumMagicPoints(override val value: Int) extends Attribute {
  override def name: String = "Maximum Magic Points"
}