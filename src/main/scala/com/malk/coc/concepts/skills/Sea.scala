package com.malk.coc.concepts.skills


final case class Sea(spent: Int) extends Survival(spent) {
  override val name = s"${super.name} (Sea)"
}