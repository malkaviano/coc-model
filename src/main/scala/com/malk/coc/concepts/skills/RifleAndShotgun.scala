package com.malk.coc.concepts.skills

final case class RifleAndShotgun() extends Firearm {
  override val name = s"${super.name} (Rifle/Shotgun)"

  override val base = 25
}