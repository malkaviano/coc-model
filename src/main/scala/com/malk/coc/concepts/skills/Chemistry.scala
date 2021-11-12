package com.malk.coc.concepts.skills

final case class Chemistry(spent: Int) extends Science(spent) {
  override val name = s"${super.name} (Chemistry)"
}