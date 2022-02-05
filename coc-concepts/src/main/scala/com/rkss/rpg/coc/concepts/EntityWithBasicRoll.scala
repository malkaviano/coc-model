package com.rkss.rpg.coc.concepts

import com.rkss.rpg.helpers.dice.HundredSidedDice

trait EntityWithBasicRoll[A] extends EntityWithBaseValue {
  def roll(implicit hundredSidedDice: HundredSidedDice): A
}
