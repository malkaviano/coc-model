package com.malk.coc.concepts.skills

class AppraiseSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Appraise"

  val skill = Appraise()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
