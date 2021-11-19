package com.malk.coc.concepts.skills

class WhipSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Whip)"

  val skill = Whip()

  behavesLikeSkill(skill, skillName, 5, false, 15)
}
