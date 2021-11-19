package com.malk.coc.concepts.skills

class GeologySpec extends BehavesLikeSkill {
  val skillName = "Science (Geology)"

  val skill = Geology()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
