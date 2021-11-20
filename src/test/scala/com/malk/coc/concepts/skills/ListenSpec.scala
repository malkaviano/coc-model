package com.malk.coc.concepts.skills

class ListenSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Listen"

  val skill = Listen()

  behavesLikeSkill(skill, skillName, 20, true, 30)

  behavesLikeSkillComparing(skill, skillName, 20, true)
}