package com.malk.coc.concepts.skills

class ActingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Art and Craft (Acting)"

  val skill = Acting()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
