package com.malk.coc.concepts.skills

class ChainsawSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Chainsaw)"

  val skill = Chainsaw(spent = 10)

  behavesLikeSkill(skill, skillName, 10, false, 20)
}