package com.malk.coc.concepts.skills

class SurvivalSpec extends BehavesLikeGenericSkill {
  val skillName = "Survival"

  val skill = new Survival {}

  behavesLikeGenericSkill(skill, skillName, 10, true)
}
