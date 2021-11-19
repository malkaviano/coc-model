package com.malk.coc.concepts.skills

class SwordSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Sword)"

  val skill = Sword()

  behavesLikeSkill(skill, skillName, 20, false, 30)
}