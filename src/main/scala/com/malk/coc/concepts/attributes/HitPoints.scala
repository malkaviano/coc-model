package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Constitution, Size}

case class HitPoints(val con: Constitution, val siz: Size) extends Attribute("Hit Points") {
  override def value: Int = (con.value + siz.value) / 10
}