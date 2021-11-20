package com.malk.coc.concepts.skills

class ClimbSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Climb"

  val skill = Climb()

  behavesLikeSkill(skill, skillName, 20, true, 30)

  behavesLikeSkillComparing(skill, skillName, 20, true)
}