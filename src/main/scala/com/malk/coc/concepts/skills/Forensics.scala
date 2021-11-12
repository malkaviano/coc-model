package com.malk.coc.concepts.skills

final case class Forensics(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Forensics)"
}