package com.rkss.rpg.coc.concepts.sanity

import com.rkss.rpg.coc.concepts._

final case class SanityRolled(
  val current: Int,
  val maximum: Int,
  val result: SanityRolledResult,
  val rolled: RollDiceResult,
)