package com.malk.coc.concepts.skills

final case class Cryptography(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Cryptography)"
}