package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.helpers.fixtures._

final case class HitPoints(
    private val size: Characteristic[Size.type],
    private val constitution: Characteristic[Constitution.type]
) {
  private val internal: BasicIntFixture[HitPointsAttribute.type] =
    BasicIntFixture(
      HitPointsAttribute,
      BasicIntOptions(
        (size.value() + constitution.value()) / 10,
        minimum = 0,
        maximum = (size.value() + constitution.value()) / 10
      )
    )

  def gain(
      gain: BasicIntValue[HitPointsAttribute.type]
  ): Unit = {
    internal.plus(gain)
  }

  def loss(
      loss: BasicIntValue[HitPointsAttribute.type]
  ): Unit = {
    internal.minus(loss)
  }

  def current: Int = internal.value

  def maximum: Int = internal.maximum
}
