package com.malk.coc.concepts.skills

class MedicineSpec extends BehavesLikeSkill {
  val skillName = "Medicine"

  val skill = Medicine(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
