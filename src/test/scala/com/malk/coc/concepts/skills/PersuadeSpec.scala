package com.malk.coc.concepts.skills

class PersuadeSpec extends BehavesLikeSkill {
  val skillName = "Persuade"

  val skill = Persuade()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
