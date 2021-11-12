package com.malk.coc.concepts.skills

final case class Bow(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Bow)"

  override val base = 15
}