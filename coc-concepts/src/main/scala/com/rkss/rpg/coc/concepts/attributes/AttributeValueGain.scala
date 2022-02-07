package com.rkss.rpg.coc.concepts.attributes

final case class AttributeValueGain[A <: AttributeName](
    val name: A,
    val value: Int
)
