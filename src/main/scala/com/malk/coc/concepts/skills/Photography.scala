package com.malk.coc.concepts.skills

final case class Photography(spent: Int) extends ArtAndCraft(spent) {
  override val name = s"${super.name} (Photography)"
}
