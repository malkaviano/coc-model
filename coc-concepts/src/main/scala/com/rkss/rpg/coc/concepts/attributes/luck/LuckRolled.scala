package com.rkss.rpg.coc.concepts.attributes.luck

import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts._

final case class LuckRolled(
    val current: Int,
    val rolled: DiceRolled,
    val result: RollResult
)
