package com.malk.coc.concepts.skills

final case class Physics() extends Science {
  override val name = s"${super.name} (Physics)"
}