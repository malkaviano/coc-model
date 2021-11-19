package com.malk.coc.concepts.skills

final case class Mathematics() extends Science {
  override val name = s"${super.name} (Mathematics)"

  override val base = 10
}