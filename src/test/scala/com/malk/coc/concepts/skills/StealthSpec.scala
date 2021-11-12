package com.malk.coc.concepts.skills

class StealthSpec extends BehavesLikeSkill {
  val skillName = "Stealth"

  val skill = Stealth(spent = 10)

  behavesLikeSkill(skill, skillName, 20, true, 30)
}