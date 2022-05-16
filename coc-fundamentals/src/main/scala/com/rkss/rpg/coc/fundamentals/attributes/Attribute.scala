package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.fixtures._

abstract class Attribute[A <: AttributeName](
    val name: A,
    initial: Int,
    max: Int
) {
  protected val internal: BasicIntFixture[A] =
    BasicIntFixture(
      name,
      BasicIntOptions(
        initial,
        minimum = 0,
        maximum = max,
        equalizeOnValueSuperiorMaximum = true
      )
    )

  def current: Int = internal.value

  def maximum: Int = internal.maximum

  def gain(
      gain: BasicIntValue[A]
  ): Unit = {
    internal.plus(gain)
  }

  def loss(
      loss: BasicIntValue[A]
  ): Unit = {
    internal.minus(loss)
  }
}
