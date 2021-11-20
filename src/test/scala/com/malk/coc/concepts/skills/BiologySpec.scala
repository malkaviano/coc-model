package com.malk.coc.concepts.skills

class BiologySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Biology)"

  val skill = Biology()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}