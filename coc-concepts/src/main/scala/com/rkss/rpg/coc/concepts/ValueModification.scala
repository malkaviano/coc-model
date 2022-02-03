package com.rkss.rpg.coc.concepts

case class ValueModification[A <: NameTag](
    val nameTag: A,
    val value: Int
)