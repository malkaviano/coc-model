package com.malk.coc.concepts.skills

class CthulhuMythosSpec extends BehavesLikeSkill {
  val skillName = "Cthulhu Mythos"

  val skill = CthulhuMythos(spent = 0)

  behavesLikeSkill(skill, skillName, 0, true, 0)
}
