package com.malk.coc.concepts.skills

class MeteorologySpec extends BehavesLikeSkill {
  val skillName = "Science (Meteorology)"

  val skill = Meteorology(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
