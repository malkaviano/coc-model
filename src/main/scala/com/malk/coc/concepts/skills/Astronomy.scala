package com.malk.coc.concepts.skills

final case class Astronomy(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Astronomy)"
}