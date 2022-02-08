package com.rkss.rpg.coc.concepts.attributes

trait DerivedAttribute[A <: AttributeName] {
  def gain(
      gain: AttributeValueGain[A]
  ): AttributeValueGained[A]

  def loss(
      loss: AttributeValueLoss[A]
  ): AttributeValueLost[A]
}
