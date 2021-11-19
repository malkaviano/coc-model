package com.malk.coc.concepts.skills

final case class Sword() extends Fighting {
  override val name = s"${super.name} (Sword)"

  override val base = 20
}