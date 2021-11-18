package com.malk.coc.concepts.skills

class WildernessTerrainSpec extends BehavesLikeSkill {
  val skillName = "Survival (Wilderness Terrain)"

  val skill = WildernessTerrain(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
