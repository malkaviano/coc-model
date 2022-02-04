package com.rkss.rpg.coc.concepts.sanity

import com.rkss.rpg.helpers.dice.HundredSidedDice

trait Sanity {
  def current: Int

  def maximum: Int

  def loss(loss: SanityLoss): SanityLost

  def gain(gain: SanityGain): SanityRecovered

  def roll(implicit hundredSidedDice: HundredSidedDice): SanityRolled
}
