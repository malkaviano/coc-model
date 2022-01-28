package com.rkss.rpg.coc.concepts.sanity

final case class SanityRecovered(
    val gained: Int,
    val current: Int,
    val previous: Int,
    val maximum: Int
)
