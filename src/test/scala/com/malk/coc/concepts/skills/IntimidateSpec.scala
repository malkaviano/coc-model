package com.malk.coc.concepts.skills

class IntimidateSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Intimidate"

  val skill = Intimidate()

  behavesLikeSkill(skill, skillName, 15, true, 25)

  behavesLikeSkillComparing(skill, skillName, 15, true)
}