package com.malk.coc.concepts.skills

final case class Zoology() extends Science {
  override val name = s"${super.name} (Zoology)"
}