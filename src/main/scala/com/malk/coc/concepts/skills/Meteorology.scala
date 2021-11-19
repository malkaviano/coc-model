package com.malk.coc.concepts.skills

final case class Meteorology() extends Science {
  override val name = s"${super.name} (Meteorology)"
}