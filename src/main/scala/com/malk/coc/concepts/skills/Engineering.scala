package com.malk.coc.concepts.skills

final case class Engineering(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Engineering)"
}