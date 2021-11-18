package com.malk.coc.concepts.skills

class ArcticSpec extends BehavesLikeSkill {
  val skillName = "Survival (Arctic)"

  val skill = Arctic(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
