package com.rkss.rpg.coc.concepts.sanity

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.characteristic._

trait Sanity {
  def initial: Characteristic[Power.type]

  def current: Int

  def maximum: Int

  def loss(loss: SanityLoss): SanityLost

  def gain(gain: SanityGain): SanityRecovered

  def currentMythos(value: Int): Unit

  def roll(implicit hundredSidedDice: HundredSidedDice): SanityRolled
}
