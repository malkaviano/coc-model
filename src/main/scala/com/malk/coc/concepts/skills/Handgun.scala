package com.malk.coc.concepts.skills

final case class Handgun(spent: Int) extends Firearm(spent) {
  override val name = s"${super.name} (Handgun)"

  override val base = 20
}