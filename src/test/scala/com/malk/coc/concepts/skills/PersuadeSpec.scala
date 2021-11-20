package com.malk.coc.concepts.skills

class PersuadeSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Persuade"

  val skill = Persuade()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
