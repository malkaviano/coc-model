package com.rkss.rpg.coc.concepts.internal

case class ValueModification[A <: Naming](
    val nameTag: A,
    val value: Int
)
