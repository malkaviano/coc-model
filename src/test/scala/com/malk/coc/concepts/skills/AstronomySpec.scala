package com.malk.coc.concepts.skills

class AstronomySpec extends BehavesLikeSkill {
  val skillName = "Science (Astronomy)"

  val skill = Astronomy(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}