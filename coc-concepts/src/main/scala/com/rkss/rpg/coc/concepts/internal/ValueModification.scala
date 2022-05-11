package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.helpers.traits._

case class ValueModification[A <: GlobalNameTag](
    val nameTag: A,
    val value: Int
)
