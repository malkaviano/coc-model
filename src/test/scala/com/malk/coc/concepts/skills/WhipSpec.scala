package com.malk.coc.concepts.skills

class WhipSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Whip)"

  val skill = Whip(spent = 10)

  behavesLikeSkill(skill, skillName, 5, false, 15)
}
