package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.coc.concepts._

final case class SanityRolled(
    val current: Int,
    val maximum: Int,
    val result: SanityRollResult,
    val rolled: DiceRolled
)
