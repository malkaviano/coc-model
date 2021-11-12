package com.malk.coc.concepts.skills

class ScienceSpec extends BehavesLikeGenericSkill {
  val skillName = "Science"

  val skill = new Science(10) {}

  behavesLikeGenericSkill(skill, skillName, 1, true)
}
