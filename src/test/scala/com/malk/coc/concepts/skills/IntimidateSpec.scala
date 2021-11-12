package com.malk.coc.concepts.skills

class IntimidateSpec extends BehavesLikeSkill {
  val skillName = "Intimidate"

  val skill = Intimidate(spent = 10)

  behavesLikeSkill(skill, skillName, 15, true, 25)
}