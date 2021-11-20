package com.malk.coc.concepts.skills

class SeaSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Survival (Sea)"

  val skill = Sea()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}