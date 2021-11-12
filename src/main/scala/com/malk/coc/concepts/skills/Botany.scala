package com.malk.coc.concepts.skills

final case class Botany(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Botany)"
}