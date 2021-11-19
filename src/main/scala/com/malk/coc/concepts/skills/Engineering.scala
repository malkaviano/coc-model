package com.malk.coc.concepts.skills

final case class Engineering() extends Science {
  override val name = s"${super.name} (Engineering)"
}