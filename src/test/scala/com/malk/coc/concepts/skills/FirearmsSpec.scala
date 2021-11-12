package com.malk.coc.concepts.skills

class FirearmSpec extends BehavesLikeGenericSkill {
  val skillName = "Firearm"

  val skill = new Firearm(10) {}

  behavesLikeGenericSkill(skill, skillName, 0, false)
}
