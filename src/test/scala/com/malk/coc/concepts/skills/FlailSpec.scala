package com.malk.coc.concepts.skills

class FlailSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Flail)"

  val skill = Flail()

  behavesLikeSkill(skill, skillName, 10, false, 20)

  behavesLikeSkillComparing(skill, skillName, 10, false)
}