package com.malk.coc.concepts.skills

class DesertSpec extends BehavesLikeSkill {
  val skillName = "Survival (Desert)"

  val skill = Desert(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
