package com.malk.coc.concepts.skills

class ForgerySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Art and Craft (Forgery)"

  val skill = Forgery()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
