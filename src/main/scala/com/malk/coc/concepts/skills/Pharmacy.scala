package com.malk.coc.concepts.skills

final case class Pharmacy(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Pharmacy)"
}