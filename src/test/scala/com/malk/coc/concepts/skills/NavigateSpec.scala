package com.malk.coc.concepts.skills

class NavigateSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Navigate"

  val skill = Navigate()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
