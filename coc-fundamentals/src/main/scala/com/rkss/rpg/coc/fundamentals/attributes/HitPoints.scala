package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.basicint._
import com.rkss.rpg.helpers._

final case class HitPoints(
    private val size: Characteristic[Size.type],
    private val constitution: Characteristic[Constitution.type]
) extends Attribute(
      HitPointsAttribute,
      (size.value() + constitution.value()) / 10,
      (size.value() + constitution.value()) / 10
    ) {

  private def onChanged(event: BasicIntEvent): Unit = {
    if (event.target == BasicIntTargetValue) {
      event.name match {
        case Size =>
          internal.maximum = (event.current + constitution.value()) / 10
        case _ =>
          internal.maximum = (size.value() + event.current) / 10
      }
    }
  }

  EventHub.addListener(size.id, this.id, onChanged)
  EventHub.addListener(constitution.id, this.id, onChanged)
}
