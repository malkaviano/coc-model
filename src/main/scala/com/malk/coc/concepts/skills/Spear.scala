package com.malk.coc.concepts.skills

final case class Spear() extends Fighting {
  override val name = s"${super.name} (Spear)"

  override val base = 20
}