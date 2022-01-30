package com.rkss.rpg.coc.concepts

final case class ValueModified(
    val name: NameTag,
    val modification: Int,
    val current: Int,
    val previous: Int
)
