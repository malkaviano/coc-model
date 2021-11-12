package com.malk.coc.concepts.skills

final case class Garrote(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Garrote)"

  override val base = 15
}