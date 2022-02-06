package com.rkss.rpg.coc.concepts.commons

import com.rkss.rpg.helpers.dice._

trait EntityWithBasicRoll[A] extends EntityWithBaseValue {
  def roll(implicit hundredSidedDice: HundredSidedDice): A
}
