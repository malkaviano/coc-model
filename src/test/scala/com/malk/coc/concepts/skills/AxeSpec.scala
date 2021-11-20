package com.malk.coc.concepts.skills

class AxeSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Axe)"

  val skill = Axe()

  behavesLikeSkill(skill, skillName, 15, false, 25)

  behavesLikeSkillComparing(skill, skillName, 15, false)
}