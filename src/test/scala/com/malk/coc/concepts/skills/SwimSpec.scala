package com.malk.coc.concepts.skills

class SwimSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Swim"

  val skill = Swim()

  behavesLikeSkill(skill, skillName, 20, true, 30)

  behavesLikeSkillComparing(skill, skillName, 20, true)
}