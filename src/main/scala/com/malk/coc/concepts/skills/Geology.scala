package com.malk.coc.concepts.skills

final case class Geology(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Geology)"
}