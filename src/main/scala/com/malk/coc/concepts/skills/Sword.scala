package com.malk.coc.concepts.skills

final case class Sword(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Sword)"

  override val base = 20
}