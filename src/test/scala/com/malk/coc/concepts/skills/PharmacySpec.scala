package com.malk.coc.concepts.skills

class PharmacySpec extends BehavesLikeSkill {
  val skillName = "Science (Pharmacy)"

  val skill = Pharmacy(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}