package com.malk.coc.concepts.skills

final case class Chainsaw() extends Fighting {
  override val name = s"${super.name} (Chainsaw)"

  override val base = 10
}