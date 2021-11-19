package com.malk.coc.concepts.skills

class CreditRatingSpec extends BehavesLikeSkill {
  val skillName = "Credit Rating"

  val skill = CreditRating()

  behavesLikeSkill(skill, skillName, 0, true, 30)
}
