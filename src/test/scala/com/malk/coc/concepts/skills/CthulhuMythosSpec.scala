package com.malk.coc.concepts.skills

class CthulhuMythosSpec extends BehavesLikeSkill {
  val skillName = "Cthulhu Mythos"

  val skill = CthulhuMythos()

  behavesLikeSkill(skill, skillName, 0, true, 0)
}
