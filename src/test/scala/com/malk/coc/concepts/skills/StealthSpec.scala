package com.malk.coc.concepts.skills

class StealthSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Stealth"

  val skill = Stealth()

  behavesLikeSkill(skill, skillName, 20, true, 30)

  behavesLikeSkillComparing(skill, skillName, 20, true)
}