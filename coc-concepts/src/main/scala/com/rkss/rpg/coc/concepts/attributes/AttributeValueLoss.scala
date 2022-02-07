package com.rkss.rpg.coc.concepts.attributes

final case class AttributeValueLoss[A <: AttributeName](
    val name: A,
    val value: Int
)
