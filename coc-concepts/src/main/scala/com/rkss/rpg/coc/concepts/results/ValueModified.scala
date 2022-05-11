package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.helpers.traits._

final case class ValueModified[A <: GlobalNameTag](
    val name: A,
    val modification: Int,
    val current: Int,
    val previous: Int
)
