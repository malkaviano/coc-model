package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.fixtures._
import com.rkss.rpg.coc.concepts.characteristic._

final case class InvestigatorMagicPoints(
    private val power: Characteristic[Power.type]
) {
  private val internal: BasicIntFixture[MagicPointsAttribute.type] =
    BasicIntFixture(
      MagicPointsAttribute,
      BasicIntOptions(
        power.value() / 5,
        minimum = 0,
        maximum = power.value() / 5
      )
    )

  def gain(
      gain: BasicIntValue[MagicPointsAttribute.type]
  ): Unit = {
    internal.plus(gain)
  }

  def loss(
      loss: BasicIntValue[MagicPointsAttribute.type]
  ): Unit = {
    internal.minus(loss)
  }

  def current: Int = internal.value

  def maximum: Int = internal.maximum
}
