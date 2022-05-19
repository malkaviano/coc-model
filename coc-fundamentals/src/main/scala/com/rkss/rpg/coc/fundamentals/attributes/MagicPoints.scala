package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.basicint._
import com.rkss.rpg.helpers._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final case class MagicPoints(
    private val power: Characteristic[Power.type]
) extends Attribute(
      MagicPointsAttribute,
      power.value() / 5,
      power.value() / 5
    ) {

  private def onChanged(event: BasicIntEvent): Unit = {
    if (event.target == BasicIntTargetValue) {
      internal.maximum = event.current / 5
    }
  }

  EventHub.addListener(power.id, this.id, onChanged)
}
