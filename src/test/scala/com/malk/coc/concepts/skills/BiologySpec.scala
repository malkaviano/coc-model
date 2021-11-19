package com.malk.coc.concepts.skills

class BiologySpec extends BehavesLikeSkill {
  val skillName = "Science (Biology)"

  val skill = Biology()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}