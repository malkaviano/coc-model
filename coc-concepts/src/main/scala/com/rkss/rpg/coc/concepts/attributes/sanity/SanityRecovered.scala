package com.rkss.rpg.coc.concepts.attributes.sanity

final case class SanityRecovered(
    val gained: Int,
    val current: Int,
    val previous: Int,
    val maximum: Int
)
