package com.malk.coc.concepts.skills

class AnthropologySpec extends BehavesLikeSkill {
  val skillName = "Anthropology"

  val skill = Anthropology()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
