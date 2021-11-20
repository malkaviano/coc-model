package com.malk.coc.concepts.skills

class MeteorologySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Meteorology)"

  val skill = Meteorology()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
