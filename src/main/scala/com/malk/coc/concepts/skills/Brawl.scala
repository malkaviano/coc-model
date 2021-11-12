package com.malk.coc.concepts.skills

final case class Brawl(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Brawl)"


  override val base = 25
}