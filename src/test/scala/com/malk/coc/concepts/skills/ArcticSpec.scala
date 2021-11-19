package com.malk.coc.concepts.skills

class ArcticSpec extends BehavesLikeSkill {
  val skillName = "Survival (Arctic)"

  val skill = Arctic()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
