package com.malk.coc.concepts.skills

class FightingSpec extends BehavesLikeGenericSkill {
  val skillName = "Fighting"

  val skill = new Fighting(10) {}

  behavesLikeGenericSkill(skill, skillName, 0, false)
}
