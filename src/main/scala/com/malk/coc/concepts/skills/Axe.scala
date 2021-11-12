package com.malk.coc.concepts.skills

final case class Axe(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Axe)"

  override val base = 15
}