package com.malk.coc.concepts.skills

final case class Chainsaw(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Chainsaw)"

  override val base = 10
}