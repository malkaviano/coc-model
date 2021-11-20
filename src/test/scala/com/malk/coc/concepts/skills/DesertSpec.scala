package com.malk.coc.concepts.skills

class DesertSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Survival (Desert)"

  val skill = Desert()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
