package com.malk.coc.concepts.skills

final case class RifleAndShotgun(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Rifle/Shotgun)"

  override val base = 25
}