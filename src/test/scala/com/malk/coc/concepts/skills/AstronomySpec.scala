package com.malk.coc.concepts.skills

class AstronomySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Astronomy)"

  val skill = Astronomy()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}