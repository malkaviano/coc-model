package com.malk.coc.concepts.skills

class PersuadeSpec extends BehavesLikeSkill {
  val skillName = "Persuade"

  val skill = Persuade(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
