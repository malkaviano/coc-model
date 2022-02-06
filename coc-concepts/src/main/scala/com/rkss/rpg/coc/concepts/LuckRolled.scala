package com.rkss.rpg.coc.concepts

final case class LuckRolled(
    val current: Int,
    val rolled: RollDiceResult,
    val result: RollResult
)
