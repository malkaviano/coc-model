package com.malk.coc.concepts.skills

class SpotHiddenSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Spot Hidden"

  val skill = SpotHidden()

  behavesLikeSkill(skill, skillName, 25, true, 35)

  behavesLikeSkillComparing(skill, skillName, 25, true)
}