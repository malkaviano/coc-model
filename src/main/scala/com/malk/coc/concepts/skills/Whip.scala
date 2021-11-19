package com.malk.coc.concepts.skills

final case class Whip() extends Fighting {
  override val name: String = s"${super.name} (Whip)"

  override val base: Int = 5
}
