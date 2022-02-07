package com.rkss.rpg.coc.concepts.attributes

trait DerivedAttribute[A <: AttributeName] {
  def current: Int

  def maximum: Int

  def gain(
      gain: AttributeValueGain[A]
  ): AttributeValueGained[A]

  def loss(
      loss: AttributeValueLoss[A]
  ): AttributeValueLost[A]
}
