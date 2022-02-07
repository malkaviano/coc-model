package com.rkss.rpg.coc.concepts.attributes

final case class AttributeValueLost[A <: AttributeName](
    val name: A,
    val lost: Int,
    val current: Int,
    val previous: Int
)
