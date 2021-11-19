package com.malk.coc.concepts.skills

class AxeSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Axe)"

  val skill = Axe()

  behavesLikeSkill(skill, skillName, 15, false, 25)
}