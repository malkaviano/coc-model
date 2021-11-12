package com.malk.coc.concepts.skills

final case class SubmachineGun(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Submachine Gun)"

  override val base = 15
}