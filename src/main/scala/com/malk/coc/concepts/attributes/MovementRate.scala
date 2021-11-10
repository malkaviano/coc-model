package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Dexterity, Strength, Size}
import com.malk.coc.concepts.traits.Attribute
import com.malk.coc.traits.Mobility

case class MovementRate(override val value: Int) extends Attribute {
  override val name = "MOV"
}