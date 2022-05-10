package com.rkss.rpg.coc.concepts.results

final case class SanityRolled(
    val current: Int,
    val maximum: Int,
    val result: SanityRollResult,
    val rolled: DiceRolled
)
