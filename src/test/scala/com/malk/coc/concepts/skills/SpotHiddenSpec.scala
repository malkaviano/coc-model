package com.malk.coc.concepts.skills

class SpotHiddenSpec extends BehavesLikeSkill {
  val skillName = "Spot Hidden"

  val skill = SpotHidden(spent = 10)

  behavesLikeSkill(skill, skillName, 25, true, 35)
}