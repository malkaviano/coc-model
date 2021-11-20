package com.malk.coc.concepts.skills

class ThrowSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Throw"

  val skill = Throw()

  behavesLikeSkill(skill, skillName, 20, false, 30)

  behavesLikeSkillComparing(skill, skillName, 1, false)
}