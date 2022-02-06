package com.rkss.rpg.coc.concepts.attributes.sanity

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.dice.HundredSidedDice

trait Sanity extends DerivedAttribute {
  def loss(loss: SanityLoss): SanityLost

  def gain(gain: SanityGain): SanityRecovered

  def roll(implicit hundredSidedDice: HundredSidedDice): SanityRolled
}
