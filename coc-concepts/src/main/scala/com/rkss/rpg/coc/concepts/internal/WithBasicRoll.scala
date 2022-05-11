package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.helpers.dice._

trait WithBasicRoll[A] extends WithBaseValue {
  def roll(implicit hundredSidedDice: HundredSidedDice): A
}
