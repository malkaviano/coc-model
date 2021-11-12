package com.malk.coc.concepts.skills

final case class Zoology(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Zoology)"
}