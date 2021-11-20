package com.malk.coc.concepts.skills

class WhipSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Whip)"

  val skill = Whip()

  behavesLikeSkill(skill, skillName, 5, false, 15)

  behavesLikeSkillComparing(skill, skillName, 1, false)
}
