package com.malk.coc.concepts.skills

class PsychologySpec extends BehavesLikeSkill {
  val skillName = "Psychology"

  val skill = Psychology()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
