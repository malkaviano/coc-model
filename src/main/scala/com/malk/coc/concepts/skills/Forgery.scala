package com.malk.coc.concepts.skills

final case class Forgery(spent: Int) extends ArtAndCraft(spent) {
  override val name = s"${super.name} (Forgery)"

  override val value: Int = base + spent
}
