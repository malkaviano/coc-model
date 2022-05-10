package com.rkss.rpg.coc.concepts.attributes.sanity

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.results._

final case class SanityRolled(
    val current: Int,
    val maximum: Int,
    val result: SanityRollResult,
    val rolled: DiceRolled
)
