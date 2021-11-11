package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.traits.Attribute

case class MovementRate(override val value: Int) extends Attribute {
  override val name = "MOV"
}