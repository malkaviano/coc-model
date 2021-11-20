package com.malk.coc.concepts.skills

class ZoologySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Zoology)"

  val skill = Zoology()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}