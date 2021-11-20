package com.malk.coc.concepts.skills

class AnthropologySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Anthropology"

  val skill = Anthropology()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
