package com.malk.coc.concepts.skills

final case class Pharmacy() extends Science {
  override val name = s"${super.name} (Pharmacy)"
}