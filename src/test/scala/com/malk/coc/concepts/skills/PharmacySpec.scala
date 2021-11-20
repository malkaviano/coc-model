package com.malk.coc.concepts.skills

class PharmacySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Pharmacy)"

  val skill = Pharmacy()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}