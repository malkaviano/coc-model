package com.malk.coc.concepts.skills

class EngineeringSpec extends BehavesLikeSkill {
  val skillName = "Science (Engineering)"

  val skill = Engineering(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}