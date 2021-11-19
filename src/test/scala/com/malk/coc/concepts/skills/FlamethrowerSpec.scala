package com.malk.coc.concepts.skills

class FlamethrowerSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Flamethrower)"

  val skill = Flamethrower()

  behavesLikeSkill(skill, skillName, 10, false, 20)
}
