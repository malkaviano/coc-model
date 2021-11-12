package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Constitution, Size}
import com.malk.coc.traits.Attribute

case class MaximumHitPoints(
  private val con: Constitution,
  private val siz: Size
) extends Attribute {
  override val name = "Maximum Hit Points"

  override def value: Int = (con.value + siz.value) / 10
}