package com.malk.coc.concepts.skills

final case class Bow() extends Firearm {
  override val name = s"${super.name} (Bow)"

  override val base = 15
}