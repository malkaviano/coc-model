package com.malk.coc.concepts.skills

class NaturalWorldSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Natural World"

  val skill = NaturalWorld()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
