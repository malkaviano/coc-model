package com.malk.coc.concepts.skills

class MedicineSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Medicine"

  val skill = Medicine()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
