package com.malk.coc.concepts.skills

final case class Desert() extends Survival {
  override val name = s"${super.name} (Desert)"
}