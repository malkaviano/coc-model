package com.malk.coc.concepts.skills

class FlamethrowerSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Flamethrower)"

  val skill = Flamethrower(spent = 10)

  behavesLikeSkill(skill, skillName, 10, false, 20)
}
