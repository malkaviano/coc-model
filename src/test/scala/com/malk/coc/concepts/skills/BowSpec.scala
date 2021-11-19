package com.malk.coc.concepts.skills

class BowSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Bow)"

  val skill = Bow()

  behavesLikeSkill(skill, skillName, 15, false, 25)
}
