package com.malk.coc.concepts.skills

class GeologySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Geology)"

  val skill = Geology()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
