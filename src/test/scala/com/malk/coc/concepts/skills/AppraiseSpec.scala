package com.malk.coc.concepts.skills

class AppraiseSpec extends BehavesLikeSkill {
  val skillName = "Appraise"

  val skill = Appraise()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
