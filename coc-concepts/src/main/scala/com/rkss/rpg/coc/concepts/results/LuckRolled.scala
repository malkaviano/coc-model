package com.rkss.rpg.coc.concepts.results

final case class LuckRolled(
    val current: Int,
    val rolled: DiceRolled,
    val result: RollResult
)
