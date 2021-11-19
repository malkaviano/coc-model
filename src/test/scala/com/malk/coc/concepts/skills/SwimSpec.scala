package com.malk.coc.concepts.skills

class SwimSpec extends BehavesLikeSkill {
  val skillName = "Swim"

  val skill = Swim()

  behavesLikeSkill(skill, skillName, 20, true, 30)
}