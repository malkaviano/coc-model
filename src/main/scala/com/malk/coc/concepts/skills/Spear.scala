package com.malk.coc.concepts.skills

final case class Spear(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Spear)"

  override val base = 20
}