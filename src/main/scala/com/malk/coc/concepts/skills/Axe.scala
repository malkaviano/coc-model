package com.malk.coc.concepts.skills

final case class Axe() extends Fighting {
  override val name = s"${super.name} (Axe)"

  override val base = 15
}