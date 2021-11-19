package com.malk.coc.concepts.skills

class ArchaeologySpec extends BehavesLikeSkill {
  val skillName = "Archaeology"

  val skill = Archaeology()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
