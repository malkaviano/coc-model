package com.malk.coc.concepts.skills

class ClimbSpec extends BehavesLikeSkill {
  val skillName = "Climb"

  val skill = Climb()

  behavesLikeSkill(skill, skillName, 20, true, 30)
}