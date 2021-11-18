package com.malk.coc.concepts.skills

final case class Arctic(spent: Int) extends Survival(spent) {
  override val name = s"${super.name} (Arctic)"
}