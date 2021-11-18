package com.malk.coc.concepts.skills

class ThrowSpec extends BehavesLikeSkill {
  val skillName = "Throw"

  val skill = Throw(spent = 10)

  behavesLikeSkill(skill, skillName, 20, false, 30)
}