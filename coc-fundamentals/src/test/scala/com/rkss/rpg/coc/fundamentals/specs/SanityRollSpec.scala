package com.rkss.rpg.coc.fundamentals.specs

import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.results._

final case class SanityRollSpec(
    val entity: Sanity,
    val rolled: Int,
    val result: SanityRollResult
) {
  val expected: SanityRolled = SanityRolled(
    entity.current,
    entity.maximum,
    result,
    DiceRolled(rolled)
  )
}
