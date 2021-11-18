package com.malk.coc.concepts.skills

final case class Desert(spent: Int) extends Survival(spent) {
  override val name = s"${super.name} (Desert)"
}