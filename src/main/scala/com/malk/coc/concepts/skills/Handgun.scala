package com.malk.coc.concepts.skills

final case class Handgun() extends Firearm {
  override val name = s"${super.name} (Handgun)"

  override val base = 20
}