package com.malk.coc.concepts.skills

final case class Meteorology(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Meteorology)"
}