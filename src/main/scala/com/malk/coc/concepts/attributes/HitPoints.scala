package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Constitution, Size}
import com.malk.coc.concepts.traits.Attribute

case class HitPoints(
  private val con: Constitution,
  private val siz: Size
) extends Attribute {
  override val name = "Hit Points"

  override def value: Int = (con.value + siz.value) / 10
}