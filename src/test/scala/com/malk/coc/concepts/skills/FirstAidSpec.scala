package com.malk.coc.concepts.skills

class FirstAidSpec extends BehavesLikeSkill {
  val skillName = "First Aid"

  val skill = FirstAid()

  behavesLikeSkill(skill, skillName, 30, true, 40)
}