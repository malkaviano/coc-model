package com.malk.coc.concepts.skills

class ChainsawSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Chainsaw)"

  val skill = Chainsaw()

  behavesLikeSkill(skill, skillName, 10, false, 20)

  behavesLikeSkillComparing(skill, skillName, 10, false)
}