package com.malk.coc.concepts.skills

class CreditRatingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Credit Rating"

  val skill = CreditRating()

  behavesLikeSkill(skill, skillName, 0, true, 30)

  behavesLikeSkillComparing(skill, skillName, 0, true)
}
