package com.malk.coc.concepts.skills

final case class SubmachineGun() extends Firearm {
  override val name = s"${super.name} (Submachine Gun)"

  override val base = 15
}