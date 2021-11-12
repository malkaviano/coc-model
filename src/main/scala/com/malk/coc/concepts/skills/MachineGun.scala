package com.malk.coc.concepts.skills

final case class MachineGun(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Machine Gun)"

  override val base = 10
}