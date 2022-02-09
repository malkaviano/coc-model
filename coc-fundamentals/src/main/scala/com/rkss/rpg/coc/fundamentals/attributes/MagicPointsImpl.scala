package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.behaviors.attributes._
import com.rkss.rpg.coc.concepts.characteristic._

final case class MagicPointsImpl(
    private val power: Characteristic[Power.type]
) extends MagicPoints
    with AttributeWithValueChangeBehavior[MagicPointsAttribute.type] {

  override def initial: Int = power.value() / 5

  override def maximum: Int = initial
}
