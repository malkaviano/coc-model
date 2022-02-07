package com.rkss.rpg.coc.concepts.attributes

import com.rkss.rpg.coc.concepts.commons.EntityWithBaseValue

trait DerivedAttribute[A <: AttributeName] extends EntityWithBaseValue {
  def current: Int

  def maximum: Int

  def gain(
      gain: AttributeValueGain[A]
  ): AttributeValueGained[A]

  def loss(
      gain: AttributeValueLoss[A]
  ): AttributeValueLost[A]
}
