package com.rkss.rpg.coc.concepts

import com.rkss.rpg.helpers.dice.HundredSidedDice

trait EntityWithBasicRoll extends EntityWithBaseValue {
  def roll(implicit hundredSidedDice: HundredSidedDice): EntityRolled
}
