package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Strength, Size}

case class BonusDamage(val str: Strength, val siz: Size) extends Attribute("Bonus Damage") {
  override def value: Int = str.value + siz.value
}