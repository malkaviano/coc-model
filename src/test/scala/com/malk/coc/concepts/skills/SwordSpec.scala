package com.malk.coc.concepts.skills

class SwordSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Sword)"

  val skill = Sword()

  behavesLikeSkill(skill, skillName, 20, false, 30)

  behavesLikeSkillComparing(skill, skillName, 20, false)
}