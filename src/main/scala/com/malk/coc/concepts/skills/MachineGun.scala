package com.malk.coc.concepts.skills

final case class MachineGun() extends Firearm {
  override val name = s"${super.name} (Machine Gun)"

  override val base = 10
}