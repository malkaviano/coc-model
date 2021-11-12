package com.malk.coc.concepts.skills

final case class Physics(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Physics)"
}