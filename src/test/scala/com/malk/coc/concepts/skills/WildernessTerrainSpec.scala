package com.malk.coc.concepts.skills

class WildernessTerrainSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Survival (Wilderness Terrain)"

  val skill = WildernessTerrain()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
