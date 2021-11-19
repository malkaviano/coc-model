package com.malk.coc.concepts.skills

final case class HeavyWeapons() extends Firearm {
  override val name = s"${super.name} (Heavy Weapons)"

  override val base = 10
}