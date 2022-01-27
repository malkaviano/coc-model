package com.rkss.rpg.coc.rules.sanity

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.sanity._

private final case class SanityRoll(
    val sanity: Sanity,
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SanityRolled = roll

  private def roll: SanityRolled = sanity.roll
}
