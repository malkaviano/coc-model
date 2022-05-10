package com.rkss.rpg.coc.concepts.internal

final case class ValueModified(
    val name: Naming,
    val modification: Int,
    val current: Int,
    val previous: Int
)
