package com.malk.coc.concepts.skills

final case class Acting(spent: Int) extends ArtAndCraft(spent) {
  override val name: String = s"${super.name} (Acting)"
}
