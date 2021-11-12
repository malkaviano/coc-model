package com.malk.coc.concepts.skills

final case class Flamethrower(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Flamethrower)"

  override val base = 10
}