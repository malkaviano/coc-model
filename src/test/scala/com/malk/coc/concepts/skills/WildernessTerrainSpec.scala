package com.malk.coc.concepts.skills

class WildernessTerrainSpec extends BehavesLikeSkill {
  val skillName = "Survival (Wilderness Terrain)"

  val skill = WildernessTerrain()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
