package com.malk.coc.concepts.skills

final case class Flail() extends Fighting {
  override val name = s"${super.name} (Flail)"

  override val base = 10
}