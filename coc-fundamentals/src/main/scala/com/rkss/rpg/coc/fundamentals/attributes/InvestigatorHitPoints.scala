package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.behaviors.attributes._
import com.rkss.rpg.coc.concepts.characteristic._

final case class InvestigatorHitPoints(
    private val size: Characteristic[Size.type],
    private val constitution: Characteristic[Constitution.type]
) extends HitPoints
    with AttributeWithValueChangeBehavior[HitPointsAttribute.type] {

  override def initial: Int = (size.value() + constitution.value()) / 10

  override val maximum: Int = initial
}
