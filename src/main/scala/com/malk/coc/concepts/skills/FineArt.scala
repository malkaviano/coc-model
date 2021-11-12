package com.malk.coc.concepts.skills

final case class FineArt(spent: Int) extends ArtAndCraft(spent) {
  override val name = s"${super.name} (Fine Art)"
}
