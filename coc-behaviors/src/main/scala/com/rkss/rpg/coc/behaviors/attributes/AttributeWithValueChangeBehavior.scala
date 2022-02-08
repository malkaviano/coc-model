package com.rkss.rpg.coc.behaviors.attributes

import com.rkss.rpg.coc.concepts.attributes._

trait AttributeWithValueChangeBehavior[A <: AttributeName] {
  self: DerivedAttribute[A]
    with AttributeWithCurrentValue
    with AttributeWithMaximumValue =>
  def initial: Int

  private var _current: Int = initial

  override def current: Int = {
    if (_current > maximum) _current = maximum

    _current
  }

  def gain(gain: AttributeValueGain[A]): AttributeValueGained[A] = {
    val name = gain.name

    val previous = current

    val delta = maximum - current

    val increase = if (gain.value > delta) delta else gain.value

    _current += increase

    AttributeValueGained(name, increase, current, previous, maximum)
  }

  def loss(
      loss: AttributeValueLoss[A]
  ): AttributeValueLost[A] = {
    val name = loss.name

    val previous = current

    val decrease = if (loss.value > current) current else loss.value

    _current -= decrease

    AttributeValueLost(name, decrease, current, previous)
  }
}
