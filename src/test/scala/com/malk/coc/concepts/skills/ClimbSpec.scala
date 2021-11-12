package com.malk.coc.concepts.skills

class ClimbSpec extends BehavesLikeSkill {
  val skillName = "Climb"

  val skill = Climb(spent = 10)

  behavesLikeSkill(skill, skillName, 20, true, 30)
}