package com.malk.coc.concepts.skills

final case class HeavyWeapons(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Heavy Weapons)"

  override val base = 10
}