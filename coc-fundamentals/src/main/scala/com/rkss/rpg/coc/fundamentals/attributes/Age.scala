package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.fixtures._

final case class Age(
    val initial: Int,
    val maximum: Int = 1000
) {
  private val internal: BasicIntFixture[AgeAttribute.type] =
    BasicIntFixture(
      AgeAttribute,
      BasicIntOptions(
        initial,
        minimum = 0,
        maximum = maximum
      )
    )

  def gain(
      gain: BasicIntValue[AgeAttribute.type]
  ): Unit = {
    internal.plus(gain)
  }

  def loss(
      loss: BasicIntValue[AgeAttribute.type]
  ): Unit = {
    internal.minus(loss)
  }

  def current: Int = internal.value
}
