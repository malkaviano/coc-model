package com.malk.coc.concepts.skills

class SpearSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Spear)"

  val skill = Spear(spent = 10)

  behavesLikeSkill(skill, skillName, 20, false, 30)
}