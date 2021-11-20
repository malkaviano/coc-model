package com.malk.coc.concepts.skills

class EngineeringSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Engineering)"

  val skill = Engineering()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}