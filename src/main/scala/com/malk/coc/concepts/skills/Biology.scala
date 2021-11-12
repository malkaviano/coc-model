package com.malk.coc.concepts.skills

final case class Biology(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Biology)"
}