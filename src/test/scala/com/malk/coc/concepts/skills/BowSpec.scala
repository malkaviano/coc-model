package com.malk.coc.concepts.skills

class BowSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Firearm (Bow)"

  val skill = Bow()

  behavesLikeSkill(skill, skillName, 15, false, 25)

  behavesLikeSkillComparing(skill, skillName, 15, false)
}
