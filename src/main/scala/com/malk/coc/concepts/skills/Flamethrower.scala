package com.malk.coc.concepts.skills

final case class Flamethrower() extends Firearm {
  override val name = s"${super.name} (Flamethrower)"

  override val base = 10
}