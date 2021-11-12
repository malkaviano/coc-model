package com.malk.coc.concepts.skills

final case class Mathematics(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Mathematics)"

  override val base = 10
}