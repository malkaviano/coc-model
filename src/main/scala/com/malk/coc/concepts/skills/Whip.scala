package com.malk.coc.concepts.skills

final case class Whip(spent: Int) extends Fighting(spent) {
  override val name: String = s"${super.name} (Whip)"

  override val base: Int = 5
}
