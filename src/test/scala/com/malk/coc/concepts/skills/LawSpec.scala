package com.malk.coc.concepts.skills

class LawSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Law"

  val skill = Law()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
