package com.malk.coc.concepts.skills

class NavigateSpec extends BehavesLikeSkill {
  val skillName = "Navigate"

  val skill = Navigate()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
