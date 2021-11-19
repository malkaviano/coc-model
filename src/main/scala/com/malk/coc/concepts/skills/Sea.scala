package com.malk.coc.concepts.skills


final case class Sea() extends Survival {
  override val name = s"${super.name} (Sea)"
}