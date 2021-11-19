package com.malk.coc.concepts.skills

final case class Astronomy() extends Science {
  override val name = s"${super.name} (Astronomy)"
}