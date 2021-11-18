package com.malk.coc.concepts.skills

final case class WildernessTerrain(spent: Int) extends Survival(spent) {
  override val name = s"${super.name} (Wilderness Terrain)"
}