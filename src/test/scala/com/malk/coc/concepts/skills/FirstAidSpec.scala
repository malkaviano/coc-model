package com.malk.coc.concepts.skills

class FirstAidSpec extends BehavesLikeSkill {
  val skillName = "First Aid"

  val skill = FirstAid(spent = 10)

  behavesLikeSkill(skill, skillName, 30, true, 40)
}