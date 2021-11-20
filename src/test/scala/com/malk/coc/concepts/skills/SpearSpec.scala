package com.malk.coc.concepts.skills

class SpearSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Spear)"

  val skill = Spear()

  behavesLikeSkill(skill, skillName, 20, false, 30)

  behavesLikeSkillComparing(skill, skillName, 20, false)
}