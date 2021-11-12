package com.malk.coc.concepts.skills

class AxeSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Axe)"

  val skill = Axe(spent = 10)

  behavesLikeSkill(skill, skillName, 15, false, 25)
}