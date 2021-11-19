package com.malk.coc.concepts.skills

class ScienceSpec extends BehavesLikeGenericSkill {
  val skillName = "Science"

  val skill = new Science() {}

  behavesLikeGenericSkill(skill, skillName, 1, true)
}
