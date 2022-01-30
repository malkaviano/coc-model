package com.rkss.rpg.coc.concepts

sealed trait ValueModification[A]

final case class ValueModificationDecrease[A <: NameTag](
    val nameTag: A,
    val value: Int
) extends ValueModification[A]

final case class ValueModificationIncrease[A <: NameTag](
    val nameTag: A,
    val value: Int
) extends ValueModification[A]