package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute

case class CurrentHitPoints(currentHP: Int) extends Attribute {
  override val name = "Current Hit Points"

  override def value: Int = currentHP
}
