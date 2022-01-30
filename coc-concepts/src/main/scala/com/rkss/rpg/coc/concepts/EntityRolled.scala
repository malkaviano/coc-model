package com.rkss.rpg.coc.concepts

final case class EntityRolled(
    val entity: EntityWithBaseValue,
    val rolled: RollDiceResult,
    val result: RollResult
)
