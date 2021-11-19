package com.malk.coc.concepts.skills

final case class Biology() extends Science {
  override val name = s"${super.name} (Biology)"
}