package com.malk.coc.concepts.skills

class SwordSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Sword)"

  val skill = Sword(spent = 10)

  behavesLikeSkill(skill, skillName, 20, false, 30)
}