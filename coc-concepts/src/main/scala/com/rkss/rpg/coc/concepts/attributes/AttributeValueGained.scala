package com.rkss.rpg.coc.concepts.attributes

final case class AttributeValueGained[A <: AttributeName](
    val name: A,
    val gained: Int,
    val current: Int,
    val previous: Int,
    val maximum: Int
)
