package com.malk.coc.concepts.skills

final case class Garrote() extends Fighting {
  override val name = s"${super.name} (Garrote)"

  override val base = 15
}