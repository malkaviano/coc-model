package com.malk.coc.concepts.skills

class StealthSpec extends BehavesLikeSkill {
  val skillName = "Stealth"

  val skill = Stealth()

  behavesLikeSkill(skill, skillName, 20, true, 30)
}