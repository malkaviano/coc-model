package com.malk.coc.concepts.skills

class OccultSpec extends BehavesLikeSkill {
  val skillName = "Occult"

  val skill = Occult(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
