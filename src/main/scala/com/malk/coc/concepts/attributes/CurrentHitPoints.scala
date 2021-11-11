package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.traits.Attribute

case class CurrentHitPoints(currentHP: Int) extends Attribute {
  override val name = "Current Hit Points"

  override def value: Int = currentHP
}
