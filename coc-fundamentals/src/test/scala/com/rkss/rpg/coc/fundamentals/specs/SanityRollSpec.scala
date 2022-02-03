package com.rkss.rpg.coc.fundamentals.specs

import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts.RollDiceResult

final case class SanityRollSpec(
  val entity: Sanity,
  val rolled: Int,
  val result: SanityRollResult
) {
  val expected: SanityRolled = SanityRolled(
    entity.current,
    entity.maximum,
    result,
    RollDiceResult(rolled)
  )
}
