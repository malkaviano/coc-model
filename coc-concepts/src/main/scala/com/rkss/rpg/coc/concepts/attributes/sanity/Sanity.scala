package com.rkss.rpg.coc.concepts.attributes.sanity

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.dice.HundredSidedDice

trait Sanity extends DerivedAttribute[SanityAttribute.type] {
  def roll(implicit hundredSidedDice: HundredSidedDice): SanityRolled
}
