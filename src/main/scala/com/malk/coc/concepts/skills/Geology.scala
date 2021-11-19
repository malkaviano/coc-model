package com.malk.coc.concepts.skills

final case class Geology() extends Science {
  override val name = s"${super.name} (Geology)"
}