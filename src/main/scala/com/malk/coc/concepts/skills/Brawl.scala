package com.malk.coc.concepts.skills

final case class Brawl() extends Fighting {
  override val name = s"${super.name} (Brawl)"


  override val base = 25
}