package com.malk.coc.concepts.skills

final case class Flail(spent: Int) extends Fighting(spent) {
  override val name = s"${super.name} (Flail)"

  override val base = 10
}