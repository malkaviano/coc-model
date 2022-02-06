package com.rkss.rpg.coc.concepts.commons

case class ValueModification[A <: Naming](
    val nameTag: A,
    val value: Int
)